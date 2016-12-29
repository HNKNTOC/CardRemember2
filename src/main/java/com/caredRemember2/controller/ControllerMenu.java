package com.caredRemember2.controller;

import com.caredRemember2.model.Menu;
import com.caredRemember2.view.ViewMenu;

/**
 * Use for control {@link Menu} and {@link ViewMenu}
 */
public class ControllerMenu extends ControllerDefault<Menu, ViewMenu> {

    @Override
    void updateDataForView() {
        view.setMapMenuItems(model.getAllMenuItem());
    }
}
