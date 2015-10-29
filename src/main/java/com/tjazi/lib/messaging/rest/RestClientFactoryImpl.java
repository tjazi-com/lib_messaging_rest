package com.tjazi.lib.messaging.rest;

import java.net.URI;

/**
 * Created by Krzysztof Wasiak on 10/10/15.
 */
public class RestClientFactoryImpl implements RestClientFactory {

    /**
     * Create REST client
     * @param targetUri Target URL
     * @return
     */
    @Override
    public RestClient createRestClient(URI targetUri) {
        return new RestClientImpl(targetUri);
    }
}
