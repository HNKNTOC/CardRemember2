package com.caredRemember2;

import com.caredRemember2.controller.ControllerExercise;
import com.caredRemember2.controller.ControllerMenu;
import com.caredRemember2.model.ListenerDefault;
import com.caredRemember2.model.Menu;
import com.caredRemember2.model.task.Exercise;
import com.caredRemember2.view.ViewExercise;
import com.caredRemember2.view.ViewExerciseSelect;
import com.caredRemember2.view.ViewMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    private static ApplicationContext contextMenu = new ClassPathXmlApplicationContext("beans/menu.xml");
    private static ApplicationContext contextExercise = new ClassPathXmlApplicationContext("beans/exercise.xml");

    public static void main(String[] args) {
        goExercise();
    }

    private static void goExercise() {
        Exercise exercise = contextExercise.getBean("exercise", Exercise.class);

        ControllerExercise controller = new ControllerExercise();
        controller.setModel(exercise);
        controller.setView(new ViewExercise());

        controller.update();
    }

    private static void goViewExercise() {
        ViewExercise view = new ViewExercise();
        view.setListenerForAnswer(new ListenerDefault());
        view.show();
    }

    private static void goExerciseSelect() {
        ViewExerciseSelect view = new ViewExerciseSelect();
        view.addNameExercise("Exercise_1");
        view.addNameExercise("Exercise_2");
        view.addNameExercise("Exercise_3");

        view.show();
    }

    private static void goMenu() {
        Menu model = contextMenu.getBean("menu", Menu.class);

        ControllerMenu controller = new ControllerMenu();
        controller.setModel(model);
        controller.setView(new ViewMenu());

        controller.update();
    }
}
