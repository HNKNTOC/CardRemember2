package com.caredRemember2.model.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ExerciseTest {

    private Exercise exercise;
    private List<CardWord> cardWords;
    private final String[] questionsMustBe = {
            "Translate Cat",
            "Translate Dog",
            "Translate Home"};

    @Before
    public void setUp() throws Exception {
        cardWords = new ArrayList<>();

        cardWords.add(createMockCardWord("Cat", "Кот"));
        cardWords.add(createMockCardWord("Dog", "Собака"));
        cardWords.add(createMockCardWord("Home", "Дом"));
        exercise = new Exercise("Test Exception", cardWords);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testInvokeMethodInCardWord() throws Exception {
        for (CardWord cardWord : cardWords) {
            verify(cardWord).getForeignWord();
        }
    }

    @Test
    public void testCreateQuestions() throws Exception {
        int i = 0;
        Iterator<Exercise.Question> iterator = exercise.getQuestionIterator();
        while (iterator.hasNext()) {
            Exercise.Question question = iterator.next();
            assertThat(question.getQuestion(), is(questionsMustBe[i]));
            assertThat(question.getAnswer(), is(nullValue()));
            i++;
        }
        assertThat("In exercise must be 3 iteration.", i, is(3));
    }

    private int idCounter = 0;

    private CardWord createMockCardWord(String foreign, String translate) {
        CardWord cardWord = mock(CardWord.class);
        when(cardWord.getForeignWord()).thenReturn(foreign);
        when(cardWord.getTranslateWord()).thenReturn(translate);
        when(cardWord.getId()).thenReturn(idCounter);
        idCounter++;
        return cardWord;
    }

    @Test
    public void testEndsAnswerOnAllQuestion() throws Exception {
        Iterator<Exercise.Question> iterator = exercise.getQuestionIterator();

        for (int i = 0; iterator.hasNext(); i++) {
            iterator.next().setAnswer(questionsMustBe[i]);
        }

        exercise.endsAnswerOnAllQuestion();

        for (int i = 0; i < cardWords.size(); i++) {
            CardWord cardWord = cardWords.get(i);
            verify(cardWord).sayAnswer(questionsMustBe[i]);
        }
    }
}