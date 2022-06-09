package com.solvd.jaxb;

import com.solvd.entities.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JAXBUnmarshaller {
    public DancersList unmarshall() throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(DancersList.class);
        return (DancersList) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/xmls/dancer.xml"));

    }
}
