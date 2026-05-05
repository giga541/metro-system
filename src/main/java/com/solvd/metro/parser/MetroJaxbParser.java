package com.solvd.metro.parser;

import com.solvd.metro.model.MetroSystemDto;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MetroJaxbParser implements Parser {

    private static final Logger logger = LogManager.getLogger(MetroJaxbParser.class);

    @Override
    public MetroSystemDto parse(String filePath) throws Exception {
        JAXBContext context = JAXBContext.newInstance(MetroSystemDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        MetroSystemDto metroSystem = (MetroSystemDto) unmarshaller.unmarshal(new File(filePath));
        logger.info("JAXB parsing complete!");
        logger.info("Trains: {}", metroSystem.getTrains().size());
        logger.info("Passengers: {}", metroSystem.getPassengers().size());
        logger.info("Stations: {}", metroSystem.getStations().size());
        logger.info("Tickets: {}", metroSystem.getTickets().size());
        logger.info("Lines: {}", metroSystem.getLines().size());
        return metroSystem;
    }
}