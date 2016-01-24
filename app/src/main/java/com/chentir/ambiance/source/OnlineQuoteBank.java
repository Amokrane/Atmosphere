package com.chentir.ambiance.source;

import android.util.Log;

import com.chentir.ambiance.http.RestClient;
import com.chentir.ambiance.model.Quote;

import java.util.ArrayList;
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

    public List<Quote> fetch() {
        Call<Quote[]> quote = mRestClient.getQuote();
        final List<Quote> quotes = new ArrayList<>();

        quote.enqueue(new Callback<Quote[]>() {
            @Override
            public void onResponse(Response<Quote[]> response) {
                // quotes = Arrays.asList(response.body());
                // To Be Continued
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("", "Could not load the quotes from " + mName + ". Reason:" + t.getMessage());
            }
        });

        return null;
    }
}
