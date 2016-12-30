package com.caredRemember2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Use for select next {@link com.caredRemember2.view.View}.
 */
public class Menu implements Model {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItem() {
        return new ArrayList<>(menuItems);
    }

    public MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }
}
