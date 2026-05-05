package com.solvd.metro.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.metro.model.MetroSystemDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MetroJacksonParser implements Parser {

    private static final Logger logger = LogManager.getLogger(MetroJacksonParser.class);

    @Override
    public MetroSystemDto parse(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        MetroSystemDto metroSystem = mapper.readValue(new File(filePath), MetroSystemDto.class);
        logger.info("Jackson parsing complete!");
        logger.info("Trains: {}", metroSystem.getTrains().size());
        logger.info("Passengers: {}", metroSystem.getPassengers().size());
        logger.info("Stations: {}", metroSystem.getStations().size());
        logger.info("Tickets: {}", metroSystem.getTickets().size());
        logger.info("Lines: {}", metroSystem.getLines().size());
        return metroSystem;
    }
}