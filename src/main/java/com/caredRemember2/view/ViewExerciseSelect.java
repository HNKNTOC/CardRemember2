package com.caredRemember2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Extract ViewSwing of ViewMenu
 */
public class ViewExerciseSelect extends ViewSwing {
    private List<String> listNameExercise = new ArrayList<>();
    private ActionListener listenerForSelect = new ExerciseSelectListener();
    private ActionListener listenerForCancel = new CancelListener();
    private JList<Object> listExercise;

    public void addNameExercise(String name) {
        listNameExercise.add(name);
    }

    public void setListNameExercise(List<String> listNameExercise) {
        this.listNameExercise = listNameExercise;
    }

    public void setListenerForSelect(ActionListener listenerForSelect) {
        this.listenerForSelect = listenerForSelect;
    }

    public void setListenerForCancel(ActionListener listenerForCancel) {
        this.listenerForCancel = listenerForCancel;
    }

    @Override
    public void show() {
        listExercise = new JList<>(listNameExercise.toArray());
        frame.add(listExercise);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);
        showFrame(frame);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton select = new JButton("Select");
        JButton cancel = new JButton("Cancel");
        select.addActionListener(listenerForSelect);
        cancel.addActionListener(listenerForCancel);
        panel.add(cancel);
        panel.add(select);
        return panel;
    }


    private class ExerciseSelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (listExercise == null)
                throw new IllegalStateException("Failed! listExercise not needs equal null. Use method show().");
            int index = listExercise.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(frame, "You not select exercise.");
            } else {
                //TODO: add Class StorageController and add .getControllerForExercise(exerciseName);
                JOptionPane.showMessageDialog(frame, "You select " + listExercise.getSelectedValue());
            }
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hide();
        }
    }
}
