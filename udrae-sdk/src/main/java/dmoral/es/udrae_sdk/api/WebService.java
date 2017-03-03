package dmoral.es.udrae_sdk.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Base64;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import dmoral.es.udrae_sdk.R;
import dmoral.es.udrae_sdk.api.config.UDRAEConfig;
import dmoral.es.udrae_sdk.api.gson_converters.JsonpGsonConverterFactory;
import dmoral.es.udrae_sdk.api.utils.Constants;
import dmoral.es.udrae_sdk.api.utils.InternetUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * This file is part of uDRAE-SDK.
 * <p>
 * uDRAE-SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p>
 * uDRAE-SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with uDRAE-SDK.  If not, see <http://www.gnu.org/licenses/>.
 */

class WebService {
    private static final String CACHE_CONTROL = "Cache-Control";

    private Retrofit retrofit;
    private UDRAEConfig udraeConfig;

    WebService(@NonNull Context context, UDRAEConfig udraeConfig) {
        this.udraeConfig = udraeConfig;
        this.retrofit = new Retrofit.Builder()
                .client(provideOkHttpClient(context))
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JsonpGsonConverterFactory.create())
                .build();
    }

    static String getBAHeader() {
        return "Basic " + Base64.encodeToString("p682JghS3:aGfUdCiE434".getBytes(), 2);
    }

    private OkHttpClient provideOkHttpClient(@NonNull Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(provideOfflineCacheInterceptor(context))
                .addNetworkInterceptor(provideCacheInterceptor())
                .cache(provideCache(context))
                .connectTimeout(udraeConfig.getConnectTimeout(), TimeUnit.SECONDS)
                .sslSocketFactory(getSSLSocketFactory(context))
                .build();
    }

    private SSLSocketFactory getSSLSocketFactory(@NonNull Context context) {
        try {
            KeyStore trustedStore = KeyStore.getInstance("BKS");
            trustedStore.load(context.getResources().openRawResource(R.raw.bks_cert), "private".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(trustedStore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
            return sslContext.getSocketFactory();
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException ignored) {
        }
        return null;
    }

    private Cache provideCache(@NonNull Context context) {
        Cache cache = null;
        try {
            cache = new Cache(new File(context.getCacheDir(), udraeConfig.getCacheFolderName()),
                    udraeConfig.getCacheSize());
        } catch (Exception ignored) {
        }
        return cache;
    }

    private Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge(udraeConfig.getCacheDuration(), TimeUnit.DAYS)
                        .build();

                return response.newBuilder()
                        .header(CACHE_CONTROL, cacheControl.toString())
                        .build();
            }
        };
    }

    private Interceptor provideOfflineCacheInterceptor(@NonNull final Context context) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (!InternetUtils.isInternetAvailable(context)) {
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxStale(udraeConfig.getOfflineCacheDuration(), TimeUnit.DAYS)
                            .build();

                    request = request.newBuilder()
                            .cacheControl(cacheControl)
                            .build();
                }

                return chain.proceed(request);
            }
        };
    }

    ApiInterface getApiInterface() {
        return this.retrofit.create(ApiInterface.class);
    }
}
