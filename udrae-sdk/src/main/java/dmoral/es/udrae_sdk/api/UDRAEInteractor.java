package dmoral.es.udrae_sdk.api;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import dmoral.es.udrae_sdk.api.config.UDRAEConfig;
import dmoral.es.udrae_sdk.api.models.AnagramResponse;
import dmoral.es.udrae_sdk.api.models.BaseResponse;
import dmoral.es.udrae_sdk.api.models.HeaderResponse;
import dmoral.es.udrae_sdk.api.models.IdResponse;
import dmoral.es.udrae_sdk.api.models.WOTDResponse;
import retrofit2.Callback;

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

public class UDRAEInteractor {
    private Context context;
    private UDRAEConfig udraeConfig;
    private ApiInterface apiInterface;

    public UDRAEInteractor(@NonNull Context context, UDRAEConfig udraeConfig) {
        this.context = context;
        this.udraeConfig = udraeConfig;
        this.apiInterface = new WebService(context, udraeConfig).getApiInterface();
    }

    public UDRAEConfig getUdraeConfig() {
        return udraeConfig;
    }

    public void setUdraeConfig(UDRAEConfig udraeConfig) {
        this.udraeConfig = udraeConfig;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void getAnagrams(String word, Callback<AnagramResponse> anagramResponseCallback) {
        apiInterface.getAnagrams(WebService.getBAHeader(), word).enqueue(anagramResponseCallback);
    }

    public void getWordsStartingWith(String wordFragment, Callback<BaseResponse> startsWithResponseCallback) {
        apiInterface.getWordsStartingWith(WebService.getBAHeader(), wordFragment).enqueue(startsWithResponseCallback);
    }

    public void getWordsContaining(String wordFragment, Callback<BaseResponse> containsResponseCallback) {
        apiInterface.getWordsContaining(WebService.getBAHeader(), wordFragment).enqueue(containsResponseCallback);
    }

    public void getWordsEndingWith(String wordFragment, Callback<BaseResponse> endsWithResponseCallback) {
        apiInterface.getWordsEndingWith(WebService.getBAHeader(), wordFragment).enqueue(endsWithResponseCallback);
    }

    public void getExactWord(String word, Callback<BaseResponse> exactResponseCallback) {
        apiInterface.getExactWord(WebService.getBAHeader(), word).enqueue(exactResponseCallback);
    }

    public void getDefinitionById(String id, Callback<String> htmlDefinitionCallback) {
        apiInterface.getDefinitionById(WebService.getBAHeader(), id).enqueue(htmlDefinitionCallback);
    }

    public void getHeaderById(String id, Callback<HeaderResponse> headerResponseCallback) {
        apiInterface.getHeaderById(WebService.getBAHeader(), id).enqueue(headerResponseCallback);
    }

    public void getIdsMatchingWord(String word, Callback<IdResponse> idResponseCallback) {
        apiInterface.getIdsMatchingWord(WebService.getBAHeader(), word).enqueue(idResponseCallback);
    }

    public void getRandomWord(Callback<String> htmlDefinitionCallback) {
        apiInterface.getRandomWord(WebService.getBAHeader()).enqueue(htmlDefinitionCallback);
    }

    public void getWordSearchResults(String word, Callback<BaseResponse> wordSearchResultsCallback) {
        apiInterface.getWordSearchResults(WebService.getBAHeader(), word).enqueue(wordSearchResultsCallback);
    }

    public void getWordOfTheDay(Callback<WOTDResponse> wotdResponseCallback) {
        apiInterface.getWordOfTheDay(WebService.getBAHeader()).enqueue(wotdResponseCallback);
    }

    public void getSomeMatchingWords(String word, Callback<ArrayList<String>> keysResponseCallback) {
        apiInterface.getSomeMatchingWords(WebService.getBAHeader(), word).enqueue(keysResponseCallback);
    }
}
