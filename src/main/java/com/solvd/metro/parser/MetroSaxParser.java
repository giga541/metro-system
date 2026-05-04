package com.solvd.metro.parser;

import com.solvd.metro.enums.StationType;
import com.solvd.metro.enums.TicketType;
import com.solvd.metro.enums.TrainStatus;
import com.solvd.metro.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * SAX Parser implementation for parsing metro.xml file.
 * Validates XML against XSD schema before parsing.
 *
 * <p>Useful XPath expressions for this XML:</p>
 * <ul>
 *   <li>{@code /metroSystem/train} - selects all train elements</li>
 *   <li>{@code /metroSystem/train/trainNumber} - selects all train numbers</li>
 *   <li>{@code /metroSystem/ticket[available='true']} - selects available tickets</li>
 *   <li>{@code /metroSystem/station/city} - selects all station cities</li>
 *   <li>{@code /metroSystem/passenger[name='Giga']} - selects passenger by name</li>
 *   <li>{@code /metroSystem/line/lineName} - selects all line names</li>
 * </ul>
 */
public class MetroSaxParser extends DefaultHandler implements Parser {

    private static final Logger logger = LogManager.getLogger(MetroSaxParser.class);

    private MetroSystemDto metroSystem;
    private Train currentTrain;
    private Passenger currentPassenger;
    private Station currentStation;
    private Ticket currentTicket;
    private Line currentLine;
    private String currentElement;

    @Override
    public MetroSystemDto parse(String filePath) throws Exception {
        validateXml(filePath);

        metroSystem = new MetroSystemDto();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new File(filePath), this);
        return metroSystem;
    }

    private void validateXml(String filePath) throws Exception {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("src/main/resources/metro.xsd"));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(filePath)));
        logger.info("XML validation successful!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        switch (qName) {
            case "train" -> currentTrain = new Train();
            case "passenger" -> currentPassenger = new Passenger();
            case "station" -> currentStation = new Station();
            case "ticket" -> currentTicket = new Ticket();
            case "line" -> currentLine = new Line();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (value.isEmpty()) return;

        if (currentTrain != null) {
            switch (currentElement) {
                case "trainNumber" -> currentTrain.setTrainNumber(Integer.parseInt(value));
                case "capacity" -> currentTrain.setCapacity(Integer.parseInt(value));
                case "status" -> currentTrain.setStatus(TrainStatus.valueOf(value));
            }
        }

        if (currentPassenger != null) {
            switch (currentElement) {
                case "name" -> currentPassenger.setName(value);
                case "seatNumber" -> currentPassenger.setSeatNumber(value);
            }
        }

        if (currentStation != null) {
            switch (currentElement) {
                case "location" -> currentStation.setLocation(value);
                case "city" -> currentStation.setCity(value);
                case "stationType" -> currentStation.setStationType(StationType.valueOf(value));
            }
        }

        if (currentTicket != null) {
            switch (currentElement) {
                case "price" -> currentTicket.setPrice(new BigDecimal(value));
                case "purchaseTime" -> currentTicket.setPurchaseTime(LocalDateTime.parse(value));
                case "available" -> currentTicket.setAvailable(Boolean.parseBoolean(value));
                case "ticketType" -> currentTicket.setTicketType(TicketType.valueOf(value));
            }
        }

        if (currentLine != null) {
            switch (currentElement) {
                case "lineName" -> currentLine.setLineName(value);
                case "distance" -> currentLine.setDistance(Double.parseDouble(value));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "train" -> {
                metroSystem.getTrains().add(currentTrain);
                currentTrain = null;
            }
            case "passenger" -> {
                metroSystem.getPassengers().add(currentPassenger);
                currentPassenger = null;
            }
            case "station" -> {
                metroSystem.getStations().add(currentStation);
                currentStation = null;
            }
            case "ticket" -> {
                metroSystem.getTickets().add(currentTicket);
                currentTicket = null;
            }
            case "line" -> {
                metroSystem.getLines().add(currentLine);
                currentLine = null;
            }
        }
    }
}