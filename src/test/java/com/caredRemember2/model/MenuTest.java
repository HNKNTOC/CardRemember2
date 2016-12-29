package com.caredRemember2.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MenuTest {
    private static final String MENU_ITEM_1 = "MenuItem_1";
    private static final String MENU_ITEM_2 = "MenuItem_2";
    private static final String MENU_ITEM_3 = "MenuItem_3";
    private Menu menu = new Menu();

    private void addItemMenu() {
        menu.addMenuItem(MENU_ITEM_1);
        menu.addMenuItem(MENU_ITEM_2);
        menu.addMenuItem(MENU_ITEM_3);
    }

    @Test
    public void checkGetAllMenuItemNames() throws Exception {
        addItemMenu();

        String[] names = menu.getAllMenuItemNames();
        assertEquals(names.length, 3);
        assertEquals(names[0], MENU_ITEM_1);
        assertEquals(names[1], MENU_ITEM_2);
        assertEquals(names[2], MENU_ITEM_3);
    }

    @Test
    public void checkAddMenuItem() throws Exception {
        addItemMenu();

        assertEquals(3, menu.sizeMenuItem());
    }

    @Test
    public void checkNameItem() throws Exception {
        addItemMenu();

        assertEquals(menu.getMenuItemName(0), MENU_ITEM_1);
        assertEquals(menu.getMenuItemName(1), MENU_ITEM_2);
        assertEquals(menu.getMenuItemName(2), MENU_ITEM_3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetMenuNameItemIfIndexIsOutOfRange() throws Exception {
        menu.getMenuItemName(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetMenuListenerItemIfIndexIsOutOfRange() throws Exception {
        menu.getItemMenuListen(0);
    }

    @Test
    public void checkAddMenuItemListener() throws Exception {
        addItemMenu();

        Menu.MenuItemListener listener0 = mock(Menu.MenuItemListener.class);
        Menu.MenuItemListener listener1 = mock(Menu.MenuItemListener.class);
        menu.addMenuItemListener(0, listener0);
        menu.addMenuItemListener(1, listener1);

        assertEquals(menu.getItemMenuListen(0).get(0), listener0);
        assertEquals(menu.getItemMenuListen(1).get(0), listener1);
    }

    @Test
    public void checkGetAllItemMenu() throws Exception {
        addItemMenu();

        menu.getAllMenuItem();
    }
}