package dmoral.es.udrae_sdk.api.gson_converters;

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

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class JsonpGsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    private JsonpGsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson can't be null");
        this.gson = gson;
    }

    public static JsonpGsonConverterFactory create() {
        return create(new Gson());
    }

    public static JsonpGsonConverterFactory create(Gson gson) {
        return new JsonpGsonConverterFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new JsonpGsonResponseBodyConverter<>(gson, type);
    }
}
