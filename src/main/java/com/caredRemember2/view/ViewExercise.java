package com.caredRemember2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Use for display
 */
public class ViewExercise extends ViewSwing {
    private String wordForeign;
    private static final String QUESTION = "Write translate word.";
    private static final String TEXT_FOR_BUTTON_ANSWER = "To answer";
    private ActionListener listenerForAnswer;

    public String getWordForeign() {
        return wordForeign;
    }

    public void setWordForeign(String wordForeign) {
        this.wordForeign = wordForeign;
    }

    public ActionListener getListenerForAnswer() {
        return listenerForAnswer;
    }

    public void setListenerForAnswer(ActionListener listenerForAnswer) {
        this.listenerForAnswer = listenerForAnswer;
    }

    @Override
    protected void settingMainFrame() {
        checkNotNull(wordForeign, "Failed! wordForeign not needs equal null. Use method setWordForeign().");
        checkNotNull(listenerForAnswer, "Failed! listenerForAnswer not needs equal null. Use method setListenerForAnswer().");

        mainFrame.add(createNorthPanel(), BorderLayout.NORTH);
        mainFrame.add(createCentralPanel(), BorderLayout.CENTER);
        JButton buttonAnswer = new JButton(TEXT_FOR_BUTTON_ANSWER);
        buttonAnswer.addActionListener(listenerForAnswer);
        mainFrame.add(buttonAnswer, BorderLayout.SOUTH);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        JLabel labelQuestion = new JLabel(QUESTION);
        labelQuestion.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(labelQuestion);
        return panel;
    }

    private JPanel createCentralPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelWordForeign = new JLabel(wordForeign);
        labelWordForeign.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(labelWordForeign);
        panel.add(new JTextField());
        return panel;
    }


}
