package com.caredRemember2.model.task;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CardWordTest {
    @Test
    public void testIdUniqueness() throws Exception {

        for (int i = 0; i < 10; i++) {
            int id = new CardWord("", "").getId();
            assertThat(id, is(i));
        }
    }
}