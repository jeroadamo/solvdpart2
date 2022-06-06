package com.solvd.staxparser;

import com.solvd.entities.Band;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXParserUtil {
    public List<Band> parser(String path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
        Band band = null;
        List<Band> bands = new ArrayList<Band>();
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "Band":
                        band = new Band();
                        Attribute id = startElement.getAttributeByName(new QName("idBand"));
                        if (id != null) {
                            band.setIdBand(Integer.parseInt(id.getValue()));
                        }
                        break;
                    case "idConcert":
                        nextEvent = reader.nextEvent();
                        band.setIdConcerts(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case "name":
                        nextEvent = reader.nextEvent();
                        band.setName(nextEvent.asCharacters().getData());
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("Band")) {
                    bands.add(band);
                }
            }
        }
        return bands;
    }
}


