package com.tjazi.lib.messaging.rest;

import com.google.gson.Gson;
import com.sun.jmx.remote.internal.Unmarshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by kr329462 on 08/10/15.
 */
public class MessageMarshallerImpl implements MessageMarshaller {

    @Override
    public String messageToXml(Object message) throws JAXBException {

        if (message == null) {
            throw new IllegalArgumentException("'message' is null.");
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(message.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // set if there should be any format in the output XML
            // e.g.: indention
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

            StringWriter targetStringWriter = new StringWriter();

            jaxbMarshaller.marshal(message, targetStringWriter);

            return targetStringWriter.toString();

        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Object xmlToMessage(String messageXml, String objectTypeName) throws JAXBException, ClassNotFoundException {

        if (messageXml == null || messageXml.isEmpty()) {
            throw new IllegalArgumentException("'messageXml' is null or empty.");
        }

        if (objectTypeName == null || objectTypeName.isEmpty()) {
            throw new IllegalArgumentException("'objectTypeName' is null or empty.");
        }

        try {

            Class messageTypeClass = Class.forName(objectTypeName);

            JAXBContext jaxbContext = JAXBContext.newInstance(messageTypeClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            StringReader sr = new StringReader(messageXml);
            return jaxbUnmarshaller.unmarshal(sr);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public String messageToJson(Object message) {

        if (message == null) {
            throw new IllegalArgumentException("'message' is null.");
        }

        Gson gson = new Gson();

        return gson.toJson(message);
    }

    @Override
    public Object jsonToMessage(String jsonString, Class objectType) {

        if (jsonString == null || jsonString.isEmpty()){
            throw new IllegalArgumentException("'jsonString' is null or empty.");
        }

        if (objectType == null){
            throw new IllegalArgumentException("'objectType' is null.");
        }

        Gson gson = new Gson();

        return gson.fromJson(jsonString, objectType);
    }
}
