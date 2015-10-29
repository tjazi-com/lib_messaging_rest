package com.tjazi.lib.messaging.rest;


/**
 * Created by Krzysztof Wasiak on 09/10/15.
 */
public interface RestClient {

    /**
     * Send request via rest to the relative URL and get response
     * @param relativeUri Relative URL
     * @param requestObject Request object (message)
     * @param expectedResponseType Expected type of the response message
     * @return
     */
    Object sendRequestGetResponse(String relativeUri, Object requestObject, Class expectedResponseType);

    /**
     * Send request via rest interface and get response
     * @param requestObject Request object (message)
     * @param expectedResponseType Expected type of the response message
     * @return
     */
    Object sendRequestGetResponse(Object requestObject, Class expectedResponseType);
}
