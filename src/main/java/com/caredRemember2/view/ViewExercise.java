package com.caredRemember2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Use for display
 */
public class ViewExercise extends ViewSwing {
    private String question = "This default string for question.";
    private static final String TEXT_FOR_BUTTON_ANSWER = "To answer";
    private ActionListener listenerForAnswer;
    private JTextField textFieldForAnswer = new JTextField();

    public ActionListener getListenerForAnswer() {
        return listenerForAnswer;
    }

    public void setListenerForAnswer(ActionListener listenerForAnswer) {
        this.listenerForAnswer = listenerForAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return textFieldForAnswer.getText().trim();
    }

    @Override
    protected void settingMainFrame() {
        checkNotNull(listenerForAnswer, "Failed! listenerForAnswer not needs equal null. Use method setListenerForAnswer().");
        mainFrame.add(createNorthPanel(), BorderLayout.NORTH);
        mainFrame.add(createCentralPanel(), BorderLayout.CENTER);
        JButton buttonAnswer = new JButton(TEXT_FOR_BUTTON_ANSWER);
        buttonAnswer.addActionListener(listenerForAnswer);
        mainFrame.add(buttonAnswer, BorderLayout.SOUTH);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        JLabel labelQuestion = new JLabel(question);
        labelQuestion.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(labelQuestion);
        return panel;
    }

    private JPanel createCentralPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(textFieldForAnswer);
        return panel;
    }


}
