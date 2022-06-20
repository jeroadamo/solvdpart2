package com.solvd.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.entities.*;
import com.solvd.service.ConcertDaoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private final static Logger LOGGER = LogManager.getLogger(JsonUtil.class);
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
    ConcertDaoService cds = new ConcertDaoService();
    Concert concert= cds.getByConcertId(2);
    public void concertWriter() {
        try {
            writer.writeValue(new File("src/main/resources/json/concert.json"), concert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void printConcert() {
        File file = new File("src/main/resources/json/concert.json");
        try {
            Concert concert1 = objectMapper.readValue(file, Concert.class);
            LOGGER.info(concert1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
