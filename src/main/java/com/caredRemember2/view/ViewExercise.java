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
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(createCentralPanel(), BorderLayout.CENTER);
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainFrame.add(mainPanel);
        mainFrame.setMinimumSize(new Dimension(100, 130));
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel();
        JButton buttonAnswer = new JButton(TEXT_FOR_BUTTON_ANSWER);
        buttonAnswer.addActionListener(listenerForAnswer);
        panel.add(buttonAnswer);
        return panel;
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
        textFieldForAnswer.setMaximumSize(new Dimension(200, 20));
        panel.add(textFieldForAnswer);
        return panel;
    }


}
