package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] strings) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class exampleClass = ExampleClass.class;

//        № 1
        Field[] fields = exampleClass.getDeclaredFields();
        for (Field field: fields){
            System.out.println(field);
        }
        System.out.println("\n");

//       № 2
        Method[] methods = exampleClass.getDeclaredMethods();
        for (Method method: methods){
            System.out.println(method);
        }
        System.out.println("\n");

//        № 3
        Constructor[] constructors = exampleClass.getConstructors();
        for (Constructor constructor: constructors){
            System.out.println(constructor);
        }
        System.out.println("\n");

//        № 4
        ExampleClass exampleClass2 = new ExampleClass();
        for (Field field: fields){
            field.setAccessible(true);
            System.out.println(field + "" + field.get(exampleClass2));
        }
        System.out.println("\n");

//        № 5
        Annotation[] annotations =  exampleClass.getAnnotations();
        for (Annotation annotation: annotations){
            System.out.println(annotation);
        }
        System.out.println("\n");

        for (Field field: fields){
            Annotation[] annotations1 = field.getAnnotations();
            for (Annotation annotation: annotations1){
                System.out.println(annotation);
            }
        }
        System.out.println("\n");

        for (Method method: methods){
            Annotation[] annotations1 = method.getAnnotations();
            for (Annotation annotation: annotations1){
                System.out.println(annotation);
            }
        }
        System.out.println("\n");

        for (Constructor constructor: constructors){
            Annotation[] annotations1 = constructor.getAnnotations();
            for (Annotation annotation: annotations1){
                System.out.println(annotation);
            }
        }

//        № 6
        exampleClass.getNestHost();
        exampleClass.getConstructor().newInstance();
        exampleClass.getConstructors()[0].newInstance();
    }
}