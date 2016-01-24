package com.chentir.ambiance.model;

/**
 * Data Model that represents a quote
 * 
 * Created by achentir on 1/23/16.
 */
public class Quote {
    final String content;
    final String title;

    public Quote(String title, String content) {
        this.content = content;
        this.title = title;
    }
}
