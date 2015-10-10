package com.tjazi.lib.messaging.rest;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.Objects;

/**
 * Created by Krzysztof Wasiak on 09/10/15.
 */
public class RestClientImpl implements RestClient {

    private URI rootServiceUri = null;

    public RestClientImpl(URI rootServiceUri) {
        if (rootServiceUri == null) {
            throw new IllegalArgumentException("'rootServiceUri' is null.");
        }

        this.rootServiceUri = rootServiceUri;
    }

    @Override
    public Object sendRequestGetResponse(String relativeUri, Object requestObject, Class expectedResponseType) {

        if (requestObject == null) {
            throw new IllegalArgumentException("'requestObject' is null.");
        }

        // this line prevents MessageBodyProviderNotFoundException exception from happening
        // using this article as reference:
        // https://stuetzpunkt.wordpress.com/2014/01/11/org-glassfish-jersey-message-internal-messagebodyprovidernotfoundexception/
        ClientConfig clientConfig = new ClientConfig().register(new JacksonFeature());

        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget target = client.target(rootServiceUri);

        if (relativeUri != null && !relativeUri.isEmpty()) {
            target.path(relativeUri);
        }

        Invocation.Builder builder = target
                .request(MediaType.APPLICATION_JSON_TYPE);

        Entity inputEntity = Entity.json(requestObject);


        return (Object)builder.post(inputEntity, expectedResponseType);
    }

    @Override
    public Object sendRequestGetResponse(Object requestObject, Class expectedResponseType) {
        return this.sendRequestGetResponse(null, requestObject, expectedResponseType);
    }
}