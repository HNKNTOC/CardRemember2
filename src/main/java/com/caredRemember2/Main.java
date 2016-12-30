package com.caredRemember2;

import com.caredRemember2.controller.ControllerMenu;
import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans/menu.xml");
    public static void main(String[] args) {
        Menu menu = context.getBean("menu", Menu.class);

        ControllerMenu controller = new ControllerMenu();
        controller.setModel(menu);
        controller.setView(new ViewMenu());

        controller.update();
    }
}
