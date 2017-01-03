package com.caredRemember2.view;

import javax.swing.*;

/**
 * Common for {@link View} use Swing.
 */
public abstract class ViewSwing implements View {
    protected final JFrame mainFrame = new JFrame();

    public JFrame getMainFrame() {
        return mainFrame;
    }

    @Override
    public void close() {
        mainFrame.dispose();
    }

    @Override
    public void show() {
        mainFrame.getContentPane().removeAll();
        settingMainFrame();
        showMainFrame(mainFrame);
    }

    /**
     * Use for setting mainFrame before display it.
     */
    protected abstract void settingMainFrame();


    protected void showMainFrame(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Use for update data without recreate frame.
     */
    public void updateContentPanel() {
        mainFrame.getContentPane().removeAll();
        settingMainFrame();
        mainFrame.revalidate();
    }

    protected static void checkNotNull(Object obj, String message) {
        if (obj == null)
            throw new IllegalStateException(message);
    }
}
