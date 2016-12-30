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
}
