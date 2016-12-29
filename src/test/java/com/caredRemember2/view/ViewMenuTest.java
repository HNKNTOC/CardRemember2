package com.caredRemember2.view;

import com.caredRemember2.model.Menu;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ViewMenuTest {
    private ViewMenu viewMenu = new ViewMenu();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void checkInvokeMenuItemsMethods() throws Exception {
        Menu.MenuItem item_0 = createMenuItemMock("Item_0");
        Menu.MenuItem item_1 = createMenuItemMock("Item_1");
        Menu.MenuItem item_2 = createMenuItemMock("Item_2");

        ArrayList<Menu.MenuItem> mapMenuItems = new ArrayList<>();
        mapMenuItems.add(item_0);
        mapMenuItems.add(item_1);
        mapMenuItems.add(item_2);

        viewMenu.setMapMenuItems(mapMenuItems);
        viewMenu.show();

        verify(item_0).getName();
        verify(item_1).getName();
        verify(item_2).getName();

    }

    private static Menu.MenuItem createMenuItemMock(String menuItemName) {
        Menu.MenuItem mock = mock(Menu.MenuItem.class);
        when(mock.getName()).thenReturn(menuItemName);
        return mock;
    }
}