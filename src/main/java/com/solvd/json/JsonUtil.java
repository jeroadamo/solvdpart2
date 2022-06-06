package com.solvd.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.entities.Area;
import com.solvd.entities.Band;
import com.solvd.entities.ElectricService;
import com.solvd.entities.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private final static Logger LOGGER = LogManager.getLogger(JsonUtil.class);
    ObjectMapper objectMapper = new ObjectMapper();
    ElectricService electricServiceEmployee = new ElectricService(1, new Area(1, "south"), true);
    public void electricServiceSetter() {
        try {
            objectMapper.writeValue(new File("src/main/resources/json/electricservice.json"), electricServiceEmployee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void esListPrinter() {
        File file = new File("src/main/resources/json/electricservices.json");
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, ElectricService.class);
        try {
            List<ElectricService> services = objectMapper.readValue(file, type);
            services.forEach(electricService -> {
                LOGGER.info(electricService);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
