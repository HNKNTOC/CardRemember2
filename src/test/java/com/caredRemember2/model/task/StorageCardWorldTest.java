package com.caredRemember2.model.task;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StorageCardWorldTest {
    @Test
    public void testGetAllCardWorld() throws Exception {
        StorageCardWorld storage = new StorageCardWorld();
        List<CardWord> allCardWorld = storage.getAllCardWorld();
        assertEquals(allCardWorld.size(), 3);
    }
}