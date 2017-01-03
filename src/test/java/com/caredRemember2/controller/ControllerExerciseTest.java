package com.caredRemember2.controller;

import com.caredRemember2.model.Exercise;
import com.caredRemember2.view.ViewExercise;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerExerciseTest {
    @Test
    public void checkUpdateData() throws Exception {
        ControllerExercise controller = new ControllerExercise();
        String value = "Test question.";
        Exercise exercise = mock(Exercise.class);
        ViewExercise viewExercise = mock(ViewExercise.class);

        when(exercise.getQuestion()).thenReturn(value);
        controller.setModel(exercise);
        controller.setView(viewExercise);
        controller.update();

        verify(viewExercise).setWordForeign(value);
    }
}