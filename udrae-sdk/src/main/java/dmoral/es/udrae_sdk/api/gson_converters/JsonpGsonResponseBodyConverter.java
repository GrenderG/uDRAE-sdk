package dmoral.es.udrae_sdk.api.gson_converters;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Converter;

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

final class JsonpGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Pattern JSONP_REGEX = Pattern.compile("(?s)\\w+\\((.*)\\).*");

    private final Gson gson;
    private final Type type;

    JsonpGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return gson.fromJson(jsonpToJson(value.string()), type);
    }

    private String jsonpToJson(String stringToConvert) {
        Matcher matcher = JSONP_REGEX.matcher(stringToConvert);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return stringToConvert;
        }
    }
}
