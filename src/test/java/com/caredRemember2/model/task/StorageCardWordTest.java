package com.caredRemember2.model.task;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StorageCardWordTest {
    @Test
    public void testGetAllCardWord() throws Exception {
        List<CardWord> allCardWord = StorageCardWord.getAllCardWords();
        assertEquals(allCardWord.size(), 3);
    }
}