package com.caredRemember2.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This default implements for ActionListener.
 * Displays info about event.
 */
//TODO: rename in ListenerDefault
public class DefaultListener implements ActionListener {
    private final Logger LOGGER = LogManager.getLogger(DefaultListener.class);

    public DefaultListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.info(e);
    }
}
