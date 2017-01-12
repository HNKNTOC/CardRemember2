package com.caredRemember2.controller;

import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExercise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerExerciseTest {

    private static final String QUESTION = "Translate Cat";
    private ControllerExercise controller = new ControllerExercise();
    @Mock
    private Exercise exercise;
    @Mock
    private ViewExercise viewExercise;
    @Mock
    private Exercise.Question question;
    @Mock
    private Iterator<Exercise.Question> questionIterator;

    private void settingMock(boolean hasNextForQuestion) {
        when(question.getQuestion()).thenReturn(QUESTION);

        when(questionIterator.hasNext()).thenReturn(hasNextForQuestion);
        when(questionIterator.next()).thenReturn(question);

        when(exercise.getQuestionIterator()).thenReturn(questionIterator);
    }

    private void useController() {
        controller.setModel(exercise);
        controller.setView(viewExercise);
        controller.update();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testCallMethodExercise() throws Exception {
        settingMock(true);
        useController();

        verify(exercise).getQuestionIterator();
        verify(question).getQuestion();
    }

    @Test
    public void testCallMethodQuestionIterator() throws Exception {
        settingMock(true);

        useController();

        verify(questionIterator).hasNext();
        verify(questionIterator).next();
    }

    @Test
    public void testCallMethodViewExercise() throws Exception {
        settingMock(true);
        useController();

        verify(viewExercise).setQuestion(QUESTION);
        verify(viewExercise).setListenerForAnswer(any(ActionListener.class));
    }

    @Test
    public void testWhenNoQuestions() throws Exception {
        settingMock(false);
        useController();

        verify(viewExercise).close();
        verify(exercise).endsAnswerOnAllQuestion();
    }

    @Test
    public void whenUseActionListener() throws Exception {
        settingMock(true);
        useController();

        ActionListener listener = controller.getListenerForAnswer();
        listener.actionPerformed(mock(ActionEvent.class));

        verify(viewExercise).getAnswer();
        verify(question).setAnswer(anyString());
        verify(viewExercise).updateContentPanel();
    }
}