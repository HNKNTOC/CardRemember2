package com.caredRemember2;

import com.caredRemember2.controller.ControllerMenu;
import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewExercise;
import com.caredRemember2.view.ViewExerciseSelect;
import com.caredRemember2.view.ViewMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans/menu.xml");

    public static void main(String[] args) {
        goViewExercise();
    }

    private static void goViewExercise() {
        ViewExercise view = new ViewExercise();
        view.setWordForeign("Cat");
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
        Menu menu = context.getBean("menu", Menu.class);

        ControllerMenu controller = new ControllerMenu();
        controller.setModel(menu);
        controller.setView(new ViewMenu());

        controller.update();
    }
}
