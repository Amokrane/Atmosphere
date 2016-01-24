package com.chentir.ambiance.http;

import com.chentir.ambiance.model.Quote;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by achentir on 1/23/16.
 */
public interface QODService {
    @GET("/wp-json/posts?filter[posts_per_page]=1")
    Call<Quote[]> getQuote();
}