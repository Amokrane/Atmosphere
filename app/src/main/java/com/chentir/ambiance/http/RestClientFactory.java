package com.chentir.ambiance.http;

/**
 * Created by achentir on 1/24/16.
 */
public class RestClientFactory {
    // TODO: Important to maintain a cache
    public RestClient create() {
        return new QODRestClient();
    }
}
