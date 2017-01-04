package com.caredRemember2.model.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * TODO: Add doc
 * Created by Nikita on 05.01.2017.
 */
public class StorageCardWorld {
    private static ApplicationContext contextCardWorld = new ClassPathXmlApplicationContext("beans/cardWorld.xml");

    public List<CardWord> getAllCardWorld() {
        return contextCardWorld.getBean("cardWorlds", List.class);
    }
}
