package com.caredRemember2.model.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CardWordTest {

    private final static String FOREIGN_WORD = "Cat";
    private final static String TRANSLATE_WORD = "Кот";
    private CardWord cardWord = new CardWord(FOREIGN_WORD, TRANSLATE_WORD);

    @Test
    public void testIdUniqueness() throws Exception {
        for (int i = 0; i < 10; i++) {
            int id = new CardWord("", "").getId();
            assertThat(id, is(i));
        }
    }

    @Test
    public void whenSayAnswerRight() throws Exception {
        cardWord.sayAnswer(TRANSLATE_WORD);
        assertThat(cardWord.getRatingMemorize(), is(1));
    }

    @Test
    public void whenSayAnswerNotRight() throws Exception {
        cardWord.sayAnswer("Собака");
        assertThat(cardWord.getRatingMemorize(), is(-1));
    }
}