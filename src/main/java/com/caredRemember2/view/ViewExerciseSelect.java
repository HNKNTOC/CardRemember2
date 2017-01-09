package com.caredRemember2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Use for display list Exercise for select
 */
public class ViewExerciseSelect extends ViewSwing {
    private List<String> listNameExercise = new ArrayList<>();
    private ActionListener listenerForSelect = new ExerciseSelectListener();
    private ActionListener listenerForCancel = new CancelListener();
    private JList<Object> listExercise;

    public void setListNameExercise(List<String> listNameExercise) {
        this.listNameExercise = listNameExercise;
    }

    public void setListenerForSelect(ActionListener listenerForSelect) {
        this.listenerForSelect = listenerForSelect;
    }

    public void setListenerForCancel(ActionListener listenerForCancel) {
        this.listenerForCancel = listenerForCancel;
    }

    //TODO: Replaced in addNameExercise param String on Enum.
    public void addNameExercise(String name) {
        listNameExercise.add(name);
    }

    @Override
    protected void settingMainFrame() {
        listExercise = new JList<>(listNameExercise.toArray());
        mainFrame.add(listExercise);
        mainFrame.add(createButtonPanel(), BorderLayout.SOUTH);
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
            checkNotNull(listExercise, "Failed! listExercise not needs equal null. Use method show().");
            int index = listExercise.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(mainFrame, "You not select exercise.");
            } else {
                //TODO: add Class StorageController and add .getControllerForExercise(exerciseName);
                JOptionPane.showMessageDialog(mainFrame, "You select " + listExercise.getSelectedValue());
            }
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            close();
        }
    }
}
