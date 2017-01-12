package com.caredRemember2.controller;

import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExercise;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Use for control {@link Exercise} and {@link ViewExercise}
 */
public class ControllerExercise extends ControllerDefault<Exercise, ViewExercise> {
    private static final Logger LOGGER = LogManager.getLogger(ControllerExercise.class);
    /**
     * Question which is set now.
     */
    private Exercise.Question nowQuestion;
    private ActionListener listenerForAnswer = new AnswerListener();

    public ControllerExercise() {
    }

    public ActionListener getListenerForAnswer() {
        return listenerForAnswer;
    }

    @Override
    void updateDataForView() {
        Iterator<Exercise.Question> iterator = model.getQuestionIterator();
        boolean hasNext = iterator.hasNext();
        if (hasNext) {
            nowQuestion = iterator.next();
            LOGGER.info("updateDataForView: Next question " + nowQuestion);
            view.setQuestion(nowQuestion.getQuestion());
            view.setListenerForAnswer(listenerForAnswer);
        } else {
            LOGGER.debug("updateDataForView: Model not has next question. View close.");
            view.close();
            model.endsAnswerOnAllQuestion();
        }
    }

    private class AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String answer = view.getAnswer();
            LOGGER.debug("Click. Answer = " + answer);
            nowQuestion.setAnswer(answer);
            updateDataForView();
            view.updateContentPanel();
        }
    }
}
