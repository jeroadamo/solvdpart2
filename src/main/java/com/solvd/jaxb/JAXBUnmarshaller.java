package com.solvd.jaxb;

import com.solvd.entities.*;
import com.solvd.service.ConcertDaoService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.util.ArrayList;

public class JAXBUnmarshaller {
    public Dancer unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Dancer.class);
        return (Dancer) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/xmls/dancers.xml"));
    }
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBUnmarshaller jaxbUnmarshaller = new JAXBUnmarshaller();
        System.out.println(jaxbUnmarshaller.unmarshall());
    }
}
