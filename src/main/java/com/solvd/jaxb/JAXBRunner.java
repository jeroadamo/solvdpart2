package com.solvd.jaxb;

import com.solvd.entities.Area;
import com.solvd.entities.Band;
import com.solvd.entities.Concert;
import com.solvd.mybatis.MyBatisRunner;
import com.solvd.service.ConcertDaoService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JAXBRunner {
    private final static Logger LOGGER = LogManager.getLogger(JAXBRunner.class);
    public static void main(String args[]) throws JAXBException, IOException {
        ArrayList<Concert> concertArrayList = new ArrayList<>();
        ConcertDaoService concertDaoService = new ConcertDaoService();
        Concert concerts = new Concert();
        Concert concert = new Concert(1, "20:30", "2hs", "27/05/2022", new Area(1, "south"), concertDaoService.getByConcertId(1).getTickets());
        Concert concert1 = new Concert(2, "22:30", "2hs", "27/05/2022", new Area(2, "north"), concertDaoService.getByConcertId(2).getTickets());
        concertArrayList.add(concert);
        concertArrayList.add(concert1);
        concerts.setConcerts(concertArrayList);
        try {
            JAXBContext context = JAXBContext.newInstance(Concert.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(concerts, new FileOutputStream("src/main/resources/jaxb/marshalled.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
