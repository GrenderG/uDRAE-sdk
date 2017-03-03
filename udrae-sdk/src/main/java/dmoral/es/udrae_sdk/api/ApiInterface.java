package dmoral.es.udrae_sdk.api;

import java.util.ArrayList;

import dmoral.es.udrae_sdk.api.models.BaseResponse;
import dmoral.es.udrae_sdk.api.models.HeaderResponse;
import dmoral.es.udrae_sdk.api.models.IdResponse;
import dmoral.es.udrae_sdk.api.models.WOTDResponse;
import dmoral.es.udrae_sdk.api.utils.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

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

interface ApiInterface {
    @GET(Constants.ANAGRAM_ENDPOINT)
    Call<BaseResponse> getAnagrams(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.STARTS_WITH_ENDPOINT)
    Call<BaseResponse> getWordsStartingWith(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.CONTAINS_ENDPOINT)
    Call<BaseResponse> getWordsContaining(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.ENDS_WITH_ENDPOINT)
    Call<BaseResponse> getWordsEndingWith(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.EXACT_ENDPOINT)
    Call<BaseResponse> getExactWord(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.FETCH_ENDPOINT)
    Call<String> getDefinitionById(@Header("Authorization") String authorization, @Query("id") String id);

    @GET(Constants.HEADER_ENDPOINT)
    Call<HeaderResponse> getHeaderById(@Header("Authorization") String authorization, @Query("id") String id);

    @GET(Constants.IDS_ENDPOINT)
    Call<IdResponse> getIdsMatchingWord(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.RANDOM_ENDPOINT)
    Call<String> getRandomWord(@Header("Authorization") String authorization);

    @GET(Constants.SEARCH_ENDPOINT)
    Call<BaseResponse> getWordSearchResults(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.WOTD_ENDPOINT)
    Call<WOTDResponse> getWordOfTheDay(@Header("Authorization") String authorization);

    @GET(Constants.KEYS_ENDPOINT)
    Call<ArrayList<String>> getSomeMatchingWords(@Header("Authorization") String authorization, @Query("q") String word);
}
