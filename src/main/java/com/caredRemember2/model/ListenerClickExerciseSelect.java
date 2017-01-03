package com.caredRemember2.model;

import com.caredRemember2.controller.ControllerExerciseSelect;
import com.caredRemember2.view.ViewExerciseSelect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This listener for handling MenuItem for select "SelectExercise".
 */
public class ListenerClickExerciseSelect implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ControllerExerciseSelect controller = new ControllerExerciseSelect();
        controller.setView(new ViewExerciseSelect());
        controller.setModel(createExercises());
        controller.update();
    }

    private ArrayList<Exercise> createExercises() {
        ArrayList<Exercise> list = new ArrayList<>();
        list.add(new Exercise("Exercise_1"));
        list.add(new Exercise("Exercise_2"));
        list.add(new Exercise("Exercise_3"));
        list.add(new Exercise("Exercise_4"));
        return list;
    }
}
