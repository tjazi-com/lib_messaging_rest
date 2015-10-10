package com.tjazi.lib.messaging.rest;


/**
 * Created by kr329462 on 09/10/15.
 */
public interface RestClient {
    Object sendRequestGetResponse(String relativeUri, Object requestObject, Class expectedResponseType);
    Object sendRequestGetResponse(Object requestObject, Class expectedResponseType);
}
