package com.chentir.ambiance.http;

import com.chentir.ambiance.model.Quote;

import retrofit2.Call;

/**
 * Created by achentir on 1/24/16.
 */
public interface RestClient {
    Call<Quote[]> getQuote();
}
