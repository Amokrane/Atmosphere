package com.chentir.ambiance.source;

import com.chentir.ambiance.entity.Quote;

import java.util.List;

/**
 * Created by achentir on 1/23/16.
 */
public abstract class QuoteBank {
    final String mName;

    QuoteBank(String name) {
        mName = name;
    }

    public abstract List<Quote> fetch();
}
