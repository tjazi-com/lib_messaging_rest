package com.tjazi.lib.messaging.rest;

import javax.xml.bind.JAXBException;

/**
 * Created by Krzysztof Wasiak on 08/10/15.
 */
public interface MessageMarshaller {

    String messageToXml(Object message) throws JAXBException;
    Object xmlToMessage(String messageXml, String objectTypeName) throws JAXBException, ClassNotFoundException;

    String messageToJson(Object message);
    Object jsonToMessage(String json, Class objectType);
}
