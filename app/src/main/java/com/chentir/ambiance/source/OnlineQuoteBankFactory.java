package com.chentir.ambiance.source;

import com.chentir.ambiance.http.RestClient;

import java.util.concurrent.ConcurrentHashMap;

import static com.chentir.ambiance.source.OnlineQuoteBank.NO_RATE_LIMIT;

/**
 * Created by achentir on 1/23/16.
 */
public class OnlineQuoteBankFactory implements QuoteBankFactory {

    final ConcurrentHashMap<String, QuoteBank> sQuoteBankCache = new ConcurrentHashMap<>();

    @Override
    public QuoteBank createQuoteBank(String name) {
        return createQuoteBank(name, null);
    }

    public QuoteBank createQuoteBank(String name, RestClient restClient) {
        return createQuoteBank(name, restClient, NO_RATE_LIMIT);
    }

    /**
     * Create a new instance of an {@link OnlineQuoteBank} with a specific rate limit
     * 
     * @param name
     * @param rateLimit
     * @return
     */
    public QuoteBank createQuoteBank(String name, RestClient restClient, int rateLimit) {
        QuoteBank quoteBank = sQuoteBankCache.get(name);

        if (quoteBank == null) {
            quoteBank = new OnlineQuoteBank(name, restClient, rateLimit);
            sQuoteBankCache.putIfAbsent(name, quoteBank);
        }

        return quoteBank;
    }
}
