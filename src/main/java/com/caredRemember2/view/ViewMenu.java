package com.caredRemember2.view;

import com.caredRemember2.model.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Use for display {@link Menu}.
 */
public class ViewMenu implements View<Menu> {
    private final JFrame frame = new JFrame();
    private Menu menu = new MenuDefault();
    private String label = "This label.";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setModel(Menu model) {
        this.menu = model;
    }

    @Override
    public void show() {
        Container contentPane = frame.getContentPane();
        contentPane.add(createMenuItemsPanel(menu), BorderLayout.CENTER);
        contentPane.add(createLabelPanel(), BorderLayout.NORTH);
        showFrame(frame);
    }

    private JPanel createLabelPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(this.label);
        panel.add(label);
        return panel;
    }

    /**
     * Use for creating {@link JPanel} on display MenuItems.
     *
     * @param menu {@link Menu} which need display on {@link JPanel}.
     */
    private JPanel createMenuItemsPanel(Menu menu) {
        int border = 10;
        JPanelMenuItems panel = new JPanelMenuItems();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for (Menu.MenuItem menuItem : menu.getAllMenuItem()) {
            panel.addMenuItem(
                    menuItem.getName(),
                    menuItem.getListeners()
            );
        }
        panel.setBorder(BorderFactory
                .createEmptyBorder(border, border, border, border));
        return panel;

    }


    private void showFrame(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Use instead null. Specifies about need set Menu.
     */
    private class MenuDefault extends Menu {

        @Override
        public List<MenuItem> getAllMenuItem() {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public void addMenuItem(String menuItemName) {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public int sizeMenuItem() {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public String getMenuItemName(int indexItemMenu) {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public List<MenuItemListener> getItemMenuListen(int indexItemMenu) {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public void addMenuItemListener(int indexItemMenu, MenuItemListener listener) {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }

        @Override
        public String[] getAllMenuItemNames() {
            throw new UnsupportedOperationException("Failed - use DefaultMenu. Set Menu for ViewMenu.");
        }
    }

    private class JPanelMenuItems extends JPanel {
        /**
         * Add MenuItem.
         *
         * @param menuItemName Name for MenuItem.
         * @param listeners    Listeners for MenuItem.
         */
        private void addMenuItem(String menuItemName, List<Menu.MenuItemListener> listeners) {
            JButton menuItem = new JButton(menuItemName);
            for (ActionListener listener : listeners) {
                menuItem.addActionListener(listener);
            }
            this.add(menuItem);
        }
    }
}
