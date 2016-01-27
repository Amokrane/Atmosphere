package com.chentir.ambiance.source;

/**
 * Created by achentir on 1/23/16.
 */
public abstract class QuoteBank {
    final String mName;

    QuoteBank(String name) {
        mName = name;
    }

    public abstract void fetchAsync();
}
