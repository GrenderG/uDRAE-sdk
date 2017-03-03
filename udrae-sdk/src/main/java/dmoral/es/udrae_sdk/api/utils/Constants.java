package dmoral.es.udrae_sdk.api.utils;

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

public class Constants {
    public static final String BASE_URL = "https://dle.rae.es/";
    public static final String ANAGRAM_ENDPOINT = "data/anagram?";
    public static final String STARTS_WITH_ENDPOINT = "data/search?m=31&f=1&t=200";
    public static final String CONTAINS_ENDPOINT = "data/search?m=33&f=1&t=200";
    public static final String EXACT_ENDPOINT = "data/search?m=30";
    public static final String FETCH_ENDPOINT = "data/fetch?";
    public static final String HEADER_ENDPOINT = "data/header?";
    public static final String IDS_ENDPOINT = "data/ids?";
    public static final String KEYS_ENDPOINT = "data/keys?callback=jsonp123";
    public static final String RANDOM_ENDPOINT = "data/random";
    public static final String SEARCH_ENDPOINT = "data/search?";
    // unused
    // public static final String TAGS_ENDPOINT = "data/search?m=16&f=1&t=200";
    public static final String ENDS_WITH_ENDPOINT = "data/search?m=32&f=1&t=200";
    public static final String WOTD_ENDPOINT = "data/wotd?callback=json";
}
