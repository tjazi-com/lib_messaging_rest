package com.tjazi.lib.messaging.rest;

import java.net.URI;

/**
 * Created by kr329462 on 10/10/15.
 */
public interface RestClientFactory {

    RestClient createRestClient(URI targetUri);
}
