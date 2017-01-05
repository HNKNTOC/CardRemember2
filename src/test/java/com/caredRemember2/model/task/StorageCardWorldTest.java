package com.caredRemember2.model.task;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StorageCardWorldTest {
    @Test
    public void testGetAllCardWorld() throws Exception {
        List<CardWord> allCardWorld = StorageCardWorld.getAllCardWords();
        assertEquals(allCardWorld.size(), 3);
    }
}