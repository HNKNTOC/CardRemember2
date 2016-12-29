package com.caredRemember2;

import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewMenu;

import java.awt.event.ActionEvent;


public class Main {
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        Menu menu = new Menu();
        addMenuItem(menu, 0);
        addMenuItem(menu, 1);
        addMenuItem(menu, 2);
        viewMenu.setModel(menu);
        viewMenu.show();
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
