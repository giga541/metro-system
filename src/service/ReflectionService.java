package service;

import annotations.MetroInfo;
import model.Train;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionService {

    public void extractInfo(Class<?> clazz) {
        System.out.println("\n--- Reflection Info: " + clazz.getSimpleName() + " ---");

        // class annotation
        if (clazz.isAnnotationPresent(MetroInfo.class)) {
            MetroInfo annotation = clazz.getAnnotation(MetroInfo.class);
            System.out.println("Description: " + annotation.description());
            System.out.println("Author: " + annotation.author());
        }

        // fields
        System.out.println("\n-- Fields --");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName()
                    + " | Type: " + field.getType().getSimpleName()
                    + " | Modifier: " + Modifier.toString(field.getModifiers()));
            if (field.isAnnotationPresent(MetroInfo.class)) {
                System.out.println("  Annotation: " + field.getAnnotation(MetroInfo.class).description());
            }
        }

        // constructors
        System.out.println("\n-- Constructors --");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println("Constructor: " + constructor.getName()
                    + " | Parameters: " + constructor.getParameterCount());
        }

        // methods
        System.out.println("\n-- Methods --");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName()
                    + " | Return type: " + method.getReturnType().getSimpleName()
                    + " | Modifier: " + Modifier.toString(method.getModifiers()));
            if (method.isAnnotationPresent(MetroInfo.class)) {
                System.out.println("  Annotation: " + method.getAnnotation(MetroInfo.class).description());
            }
        }
    }

    public void createObjectAndCallMethod() {
        try {
            // create object using reflection
            Class<?> trainClass = Class.forName("model.Train");
            Object train = trainClass.getDeclaredConstructor().newInstance();

            // set value using reflection
            Method setTrainNumber = trainClass.getMethod("setTrainNumber", int.class);
            setTrainNumber.invoke(train, 999);

            // call method using reflection
            Method getTrainNumber = trainClass.getMethod("getTrainNumber");
            System.out.println("Train number via reflection: " + getTrainNumber.invoke(train));

            Method getType = trainClass.getMethod("getType");
            System.out.println("Train type via reflection: " + getType.invoke(train));

        } catch (Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }
}