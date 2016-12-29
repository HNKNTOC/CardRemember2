package com.caredRemember2;

import com.caredRemember2.controller.ControllerMenu;
import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewMenu;

import java.awt.event.ActionEvent;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        addMenuItem(menu, 0);
        addMenuItem(menu, 1);
        addMenuItem(menu, 2);

        ControllerMenu controller = new ControllerMenu();
        controller.setModel(menu);
        controller.setView(new ViewMenu());

        controller.update();
    }

    private static void addMenuItem(Menu menu, int indexItemMenu) {
        menu.addMenuItem("Item " + indexItemMenu);
        menu.addMenuItemListener(indexItemMenu, new MyListeners(menu.getMenuItem(indexItemMenu), "Click " + indexItemMenu));
    }

    private static class MyListeners extends Menu.MenuItemListener {
        private final String message;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(message);
        }

        private MyListeners(Menu.MenuItem menuItem, String message) {
            super(menuItem);
            this.message = message;
        }
    }
}
