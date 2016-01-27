package com.chentir.ambiance.ui.presenter;

import com.chentir.ambiance.source.OnlineQuoteBank;
import com.chentir.ambiance.source.QuoteBank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achentir on 1/24/16.
 */
public class StartPresenter {
    final List<QuoteBank> mQuoteBanks = new ArrayList<>();

    public void addQuoteBank(QuoteBank quoteBank) {
        mQuoteBanks.add(quoteBank);
    }

    public void downloadQuotes() {
        for (QuoteBank quoteBank : mQuoteBanks) {
            if (quoteBank instanceof OnlineQuoteBank) {
                OnlineQuoteBank onlineQuoteBank = (OnlineQuoteBank) quoteBank;
                onlineQuoteBank.fetchAsync();
            }
        }
    }
}
