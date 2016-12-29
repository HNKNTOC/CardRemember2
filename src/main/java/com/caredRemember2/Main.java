package com.caredRemember2;

import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewMenu;


public class Main {
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        Menu menu = new Menu();
        menu.addMenuItem("Item 0");
        menu.addMenuItem("Item 1");
        menu.addMenuItem("Item 2");
        viewMenu.setModel(menu);
        viewMenu.show();
    }
}
