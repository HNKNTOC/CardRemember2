package com.caredRemember2.model.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * This storage use for get CardWord.
 */
public class StorageCardWord {
    private static ApplicationContext contextCardWord = new ClassPathXmlApplicationContext("beans/cardWord.xml");

    private StorageCardWord() {
    }

    public static List<CardWord> getAllCardWords() {
        return contextCardWord.getBean("cardWords", List.class);
    }
}
