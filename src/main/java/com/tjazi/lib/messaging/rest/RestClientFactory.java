package com.tjazi.lib.messaging.rest;

import java.net.URI;

/**
 * Created by Krzysztof Wasiak on 10/10/15.
 */
public interface RestClientFactory {

    /**
     * Create REST client
     * @param targetUri Target URL
     * @return
     */
    RestClient createRestClient(URI targetUri);
}
