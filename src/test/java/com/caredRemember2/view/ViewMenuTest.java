package com.caredRemember2.view;

import com.caredRemember2.model.Menu;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ViewMenuTest {
    private ViewMenu viewMenu = new ViewMenu();

    @Test(expected = UnsupportedOperationException.class)
    public void whenNotSetModel() throws Exception {
        viewMenu.show();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void checkInvokeMenuItemsMethods() throws Exception {
        Menu menu = mock(Menu.class);
        Menu.MenuItem item_0 = createMenuItemMock("Item_0");
        Menu.MenuItem item_1 = createMenuItemMock("Item_1");
        Menu.MenuItem item_2 = createMenuItemMock("Item_2");

        ArrayList<Menu.MenuItem> value = new ArrayList<>();
        value.add(item_0);
        value.add(item_1);
        value.add(item_2);

        when(menu.getAllMenuItem()).thenReturn(value);
        viewMenu.setModel(menu);
        viewMenu.show();

        verify(menu, only()).getAllMenuItem();
        verify(item_0, times(1)).getName();
        verify(item_1, times(1)).getName();
        verify(item_2, times(1)).getName();

    }

    private static Menu.MenuItem createMenuItemMock(String menuItemName) {
        Menu.MenuItem mock = mock(Menu.MenuItem.class);
        when(mock.getName()).thenReturn(menuItemName);
        return mock;
    }
}