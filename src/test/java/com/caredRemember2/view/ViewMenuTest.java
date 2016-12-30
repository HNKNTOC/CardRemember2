package com.caredRemember2.view;

import com.caredRemember2.model.MenuItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ViewMenuTest {
    private ViewMenu viewMenu = new ViewMenu();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void checkInvokeMenuItemsMethods() throws Exception {
        MenuItem item_0 = createMenuItemMock("Item_0");
        MenuItem item_1 = createMenuItemMock("Item_1");
        MenuItem item_2 = createMenuItemMock("Item_2");

        ArrayList<MenuItem> mapMenuItems = new ArrayList<>();
        mapMenuItems.add(item_0);
        mapMenuItems.add(item_1);
        mapMenuItems.add(item_2);

        viewMenu.setMapMenuItems(mapMenuItems);
        viewMenu.show();

        verify(item_0).getName();
        verify(item_1).getName();
        verify(item_2).getName();

    }

    private static MenuItem createMenuItemMock(String menuItemName) {
        MenuItem mock = mock(MenuItem.class);
        when(mock.getName()).thenReturn(menuItemName);
        return mock;
    }
}