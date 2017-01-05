package com.caredRemember2.model.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * This storage use for get CardWorld.
 */
public class StorageCardWorld {
    private static ApplicationContext contextCardWorld = new ClassPathXmlApplicationContext("beans/cardWorld.xml");

    private StorageCardWorld() {
    }

    public static List<CardWord> getAllCardWords() {
        return contextCardWorld.getBean("cardWords", List.class);
    }
}
