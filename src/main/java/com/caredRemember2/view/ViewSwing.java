package com.caredRemember2.view;

import javax.swing.*;

/**
 * Common for {@link View} use Swing.
 */
public abstract class ViewSwing implements View {
    protected final JFrame frame = new JFrame();

    public JFrame getFrame() {
        return frame;
    }

    protected void showFrame(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
