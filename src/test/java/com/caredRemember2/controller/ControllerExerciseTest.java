package com.caredRemember2.controller;

import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExercise;
import org.junit.Test;

import java.awt.event.ActionListener;

import static org.mockito.Mockito.*;

public class ControllerExerciseTest {
    @Test
    public void checkDataForView() throws Exception {
        ControllerExercise controller = new ControllerExercise();
        String value = "Test question.";
        Exercise exercise = mock(Exercise.class);
        ViewExercise viewExercise = mock(ViewExercise.class);

        //when(exercise.getQuestion()).thenReturn(value);
        controller.setModel(exercise);
        controller.setView(viewExercise);
        controller.update();

        verify(viewExercise).setQuestion(value);
        verify(viewExercise).setListenerForAnswer(any(ActionListener.class));
    }
}