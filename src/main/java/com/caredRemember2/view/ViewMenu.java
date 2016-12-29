package com.caredRemember2.view;

import com.caredRemember2.model.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Use for display {@link Menu}.
 */
public class ViewMenu implements View {
    private final JFrame frame = new JFrame();
    private String label = "This label.";
    private List<Menu.MenuItem> mapMenuItems = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setMapMenuItems(List<Menu.MenuItem> mapMenuItems) {
        this.mapMenuItems = mapMenuItems;
    }

    @Override
    public void show() {
        Container contentPane = frame.getContentPane();
        contentPane.add(createMenuItemsPanel(), BorderLayout.CENTER);
        contentPane.add(createLabel(), BorderLayout.NORTH);
        showFrame(frame);
    }

    private JLabel createLabel() {
        JLabel label = new JLabel(this.label);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void addMenuItem(Menu.MenuItem menuItem) {
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

        for (Menu.MenuItem mapMenuItem : mapMenuItems) {
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


    private void showFrame(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
            menuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(menuItem);
        }
    }
}
