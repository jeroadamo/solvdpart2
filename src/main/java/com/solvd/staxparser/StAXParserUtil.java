package com.solvd.staxparser;

import com.solvd.entities.Band;
import com.solvd.entities.Ticket;

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
    public List<Ticket> parser(String path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
        Ticket ticket = null;
        List<Ticket> tickets = new ArrayList<Ticket>();
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "Ticket":
                        ticket = new Ticket();
                        nextEvent = reader.nextEvent();
                        break;
                    case "email":
                        nextEvent = reader.nextEvent();
                        ticket.setEmail(nextEvent.asCharacters().getData());
                        break;
                    case "TicketId":
                        nextEvent = reader.nextEvent();
                        ticket.setIdTickets(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case "CompleteName":
                        nextEvent = reader.nextEvent();
                        ticket.setNameSurname(nextEvent.asCharacters().getData());
                        break;
                    case "NationalIdentification":
                        nextEvent = reader.nextEvent();
                        ticket.setNationalId(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("Ticket")) {
                    tickets.add(ticket);
                }
            }
        }
        return tickets;
    }
}


