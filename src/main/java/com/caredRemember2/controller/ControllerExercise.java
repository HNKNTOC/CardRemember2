package com.caredRemember2.controller;

import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExercise;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Use for control {@link Exercise} and {@link ViewExercise}
 */
public class ControllerExercise extends ControllerDefault<Exercise, ViewExercise> {
    private static final Logger LOGGER = LogManager.getLogger(ControllerExercise.class);
    @Override
        //TODO: remodel.
    void updateDataForView() {
        //view.setQuestion(model.getQuestion());
        view.setListenerForAnswer(new AnswerListener());
    }

    private class AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String answer = view.getAnswer();
            LOGGER.debug("Click. Answer = " + answer);
            //model.handlingAnswer(answer);
            //if (model.hasNextQuestion()) {
                LOGGER.debug("Next question.");
            //model.nextQuestion();
                updateDataForView();
                view.updateContentPanel();
            //} else {
                LOGGER.debug("Has next question return false. View close.");
                view.close();
            //}
        }
    }
}
