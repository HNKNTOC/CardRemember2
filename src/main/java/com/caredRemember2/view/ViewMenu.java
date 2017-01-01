package com.caredRemember2.view;

import com.caredRemember2.model.Menu;
import com.caredRemember2.model.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Use for display {@link Menu}.
 */
public class ViewMenu extends ViewSwing {
    private String menuLabel = "This label.";
    private List<com.caredRemember2.model.MenuItem> mapMenuItems = new ArrayList<>();

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public void setMapMenuItems(List<MenuItem> mapMenuItems) {
        this.mapMenuItems = mapMenuItems;
    }

    @Override
    protected void settingMainFrame() {
        Container contentPane = mainFrame.getContentPane();
        contentPane.add(createMenuItemsPanel(), BorderLayout.CENTER);
        contentPane.add(createLabel(), BorderLayout.NORTH);
    }

    private JLabel createLabel() {
        JLabel label = new JLabel(this.menuLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void addMenuItem(MenuItem menuItem) {
        mapMenuItems.add(menuItem);
    }

    public int getMenuItemSize() {
        return mapMenuItems.size();
    }

    public void removeMenuItem() {
        mapMenuItems.clear();
    }

    /**
     * Use for creating {@link JPanel} on display MenuItems.
     */
    private JPanel createMenuItemsPanel() {
        JPanelMenuItems panel = new JPanelMenuItems();
        settingForMenuItemsPanel(panel);

        for (MenuItem mapMenuItem : mapMenuItems) {
            panel.addMenuItem(
                    mapMenuItem.getName(),
                    mapMenuItem.getListeners()
            );
        }
        return panel;

    }

    private void settingForMenuItemsPanel(JPanelMenuItems panel) {
        int border = 10;
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory
                .createEmptyBorder(border, border, border, border));
    }

    private class JPanelMenuItems extends JPanel {
        /**
         * Add MenuItem.
         *
         * @param menuItemName Name for MenuItem.
         * @param listeners    Listeners for MenuItem.
         */
        private void addMenuItem(String menuItemName, List<? extends ActionListener> listeners) {
            JButton menuItem = new JButton(menuItemName);
            for (ActionListener listener : listeners) {
                menuItem.addActionListener(listener);
            }
            menuItem.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            this.add(menuItem);
        }
    }
}
