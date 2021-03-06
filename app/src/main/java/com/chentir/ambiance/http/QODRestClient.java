package com.chentir.ambiance.http;

import com.chentir.ambiance.model.QuoteModel;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by achentir on 1/23/16.
 */
public class QODRestClient implements RestClient {
    static final String BASE_URL = "http://quotesondesign.com";

    public Call<QuoteModel[]> getQuoteCall() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .build();

        // How many times should this be called?
        QODService service = retrofit.create(QODService.class);
        Call<QuoteModel[]> quote = service.getQuote();

        return quote;
    }
}
