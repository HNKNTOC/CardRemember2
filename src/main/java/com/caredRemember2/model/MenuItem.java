package com.caredRemember2.model;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the data need for MenuItem.
 */
public class MenuItem {
    private String name;
    private List<ActionListener> listeners = new ArrayList<>();

    private MenuItem(String name) {
        this.name = name;
    }

    /**
     * Create MenuItem with add one {@link java.awt.event.ActionListener}
     *
     * @param name             Name for MenuItem.
     * @param menuItemListener One listener for add in MenuItem.
     */
    public MenuItem(String name, ActionListener menuItemListener) {
        this(name);
        this.listeners.add(menuItemListener);
    }

    public String getName() {
        return name;
    }

    public List<ActionListener> getListeners() {
        return listeners;
    }

    private void addListener(ListenerDefault listener) {
        this.listeners.add(listener);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
