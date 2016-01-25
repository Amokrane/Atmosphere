package com.chentir.ambiance.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chentir.ambiance.R;
import com.chentir.ambiance.http.RestClient;
import com.chentir.ambiance.http.RestClientFactory;
import com.chentir.ambiance.source.OnlineQuoteBankFactory;
import com.chentir.ambiance.source.QuoteBank;
import com.chentir.ambiance.ui.presenter.StartPresenter;

public class StartActivity extends AppCompatActivity {

    StartPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Normally this would be stored in a local datastore prior to entering this activity, during some
        // initialization step

        RestClient restClient = new RestClientFactory().create();
        QuoteBank quoteBank = new OnlineQuoteBankFactory().createQuoteBank("QuotesOnDesign", restClient);
        mPresenter = new StartPresenter();
        mPresenter.addQuoteBank(quoteBank);
        mPresenter.downloadQuotes();
    }
}
