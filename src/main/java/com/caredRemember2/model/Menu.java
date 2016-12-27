package com.caredRemember2.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu use for select next View.
 */
public class Menu implements Model {
    private static final Logger LOGGER = LogManager.getLogger(Menu.class);
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(String menuItemName) {
        menuItems.add(new MenuItem(menuItemName));
    }

    public int sizeMenuItem() {
        return menuItems.size();
    }

    public String getItemMenuName(int indexItemMenu) {
        return menuItems.get(indexItemMenu).getName();
    }

    public List<MenuItemListener> getItemMenuListen(int indexItemMenu) {
        return menuItems.get(indexItemMenu).getListeners();
    }

    public void addMenuItemListener(int indexItemMenu, MenuItemListener listener) {
        menuItems.get(indexItemMenu).addListener(listener);
    }

    public String[] getAllMenuItemNames() {
        String[] names = new String[menuItems.size()];
        for (int i = 0; i < menuItems.size(); i++) {
            names[i] = menuItems.get(i).getName();
        }
        return names;
    }


    private class MenuItem {
        private String name;
        private List<MenuItemListener> listeners = new ArrayList<>();

        public MenuItem(String menuItemName) {
            this.name = menuItemName;
        }

        public String getName() {
            return name;
        }

        public List<MenuItemListener> getListeners() {
            return listeners;
        }

        public void addListener(MenuItemListener listener) {
            this.listeners.add(listener);
        }
    }

    public static class MenuItemListener implements ActionListener {
        private final Logger LOGGER = LogManager.getLogger(MenuItemListener.class);

        private MenuItem menuItem;

        public MenuItemListener(MenuItem menuItem) {
            this.menuItem = menuItem;
        }

        public MenuItem getMenuItem() {
            return menuItem;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e);
        }
    }
}
