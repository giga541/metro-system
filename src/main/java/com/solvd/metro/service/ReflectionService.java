package com.solvd.metro.service;

import com.solvd.metro.annotations.MetroInfo;
import com.solvd.metro.model.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;

public class ReflectionService {

    private static final Logger logger = LogManager.getLogger(ReflectionService.class);

    public void extractInfo(Class<?> clazz) {
        logger.info("Reflection Info: {}", clazz.getSimpleName());

        if (clazz.isAnnotationPresent(MetroInfo.class)) {
            MetroInfo annotation = clazz.getAnnotation(MetroInfo.class);
            logger.info("Description: {}", annotation.description());
            logger.info("Author: {}", annotation.author());
        }

        logger.info("-- Fields --");
        for (Field field : clazz.getDeclaredFields()) {
            logger.info("Field: {} | Type: {} | Modifier: {}", field.getName(), field.getType().getSimpleName(), Modifier.toString(field.getModifiers()));

            if (field.isAnnotationPresent(MetroInfo.class)) {
                logger.info("Annotation: {}", field.getAnnotation(MetroInfo.class).description());
            }
        }

        logger.info("-- Constructors --");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            logger.info("Constructor: {} | Parameters: {}", constructor.getName(), constructor.getParameterCount());
        }

        logger.info("-- Methods --");
        for (Method method : clazz.getDeclaredMethods()) {
            logger.info("Method: {} | Return type: {} | Modifier: {}", method.getName(), method.getReturnType().getSimpleName(), Modifier.toString(method.getModifiers()));

            if (method.isAnnotationPresent(MetroInfo.class)) {
                logger.info("Annotation: {}", method.getAnnotation(MetroInfo.class).description());
            }
        }
    }

    public void createObjectAndCallMethod() {
        try {
            Class<?> trainClass = Class.forName("com.solvd.metro.model.Train");
            Object train = trainClass.getDeclaredConstructor().newInstance();

            Method setTrainNumber = trainClass.getMethod("setTrainNumber", int.class);
            setTrainNumber.invoke(train, 999);

            Method getTrainNumber = trainClass.getMethod("getTrainNumber");
            logger.info("Train number via reflection: {}", getTrainNumber.invoke(train));

            Method getType = trainClass.getMethod("getType");
            logger.info("Train type via reflection: {}", getType.invoke(train));

        } catch (Exception e) {
            logger.error("Reflection error: {}", e.getMessage());
        }
    }

    public Optional<Train> createTrainWithReflection() {
        try {
            Class<?> trainClass = Class.forName("com.solvd.metro.model.Train");
            Object train = trainClass.getDeclaredConstructor().newInstance();

            Method setTrainNumber = trainClass.getMethod("setTrainNumber", int.class);
            setTrainNumber.invoke(train, 999);

            return Optional.of((Train) train);
        } catch (Exception e) {
            logger.error("Could not create train: {}", e.getMessage());
            return Optional.empty();
        }
    }
}