package com.solvd.staxparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.awt.*;
import java.io.FileNotFoundException;

public class StAXParserRunner {
    private final static Logger LOGGER = LogManager.getLogger(StAXParserRunner.class);
    public static void main(String[] args) {
        StAXParserUtil stAXParserUtil = new StAXParserUtil();
        try {
            LOGGER.info(stAXParserUtil.parser("src/main/resources/staxparser/bands.xml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}
