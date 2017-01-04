package com.caredRemember2.controller;

import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExerciseSelect;

import java.util.List;

/**
 * Use for control List<Exercise> and {@link ViewExerciseSelect}
 */
public class ControllerExerciseSelect
        extends ControllerDefault<List<Exercise>, ViewExerciseSelect> {
    @Override
    void updateDataForView() {
        for (Exercise exercise : model) {
            view.addNameExercise(exercise.getName());
        }
    }
}
