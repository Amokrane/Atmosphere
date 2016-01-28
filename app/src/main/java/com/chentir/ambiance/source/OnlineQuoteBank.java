package com.chentir.ambiance.source;

import android.util.Log;

import com.chentir.ambiance.http.RestClient;
import com.chentir.ambiance.model.QuoteModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by achentir on 1/23/16.
 */
public class OnlineQuoteBank extends QuoteBank {
    static final int NO_RATE_LIMIT = -1;

    final int mRateLimit;
    final RestClient mRestClient;

    OnlineQuoteBank(String name, RestClient restClient, int rateLimit) {
        super(name);
        mRateLimit = rateLimit;
        mRestClient = restClient;
    }

    public void fetchAsync() {
        Call<QuoteModel[]> quoteCall = mRestClient.getQuoteCall();
        final List<QuoteModel> quotes = new ArrayList<>();

        quoteCall.enqueue(new Callback<QuoteModel[]>() {
            @Override
            public void onResponse(Response<QuoteModel[]> response) {
                quotes.addAll(Arrays.asList(response.body()));
                response.raw().body().close();
                // TODO: Write batch transaction
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("", "Could not load the quotes from " + mName + ". Reason:" + t.getMessage());
            }
        });
    }
}
