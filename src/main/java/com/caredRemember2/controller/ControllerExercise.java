package com.caredRemember2.controller;

import com.caredRemember2.model.Exercise;
import com.caredRemember2.view.ViewExercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO: Add doc
 * Created by Nikita on 27.12.2016.
 */
public class ControllerExercise extends ControllerDefault<Exercise, ViewExercise> {
    @Override
    void updateDataForView() {
        view.setWordForeign(model.getQuestion());
    }

    private class AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
