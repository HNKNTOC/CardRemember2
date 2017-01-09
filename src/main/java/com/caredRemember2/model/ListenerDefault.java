package com.caredRemember2.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This default implements for ActionListener.
 * Displays info about event.
 */
public class ListenerDefault implements ActionListener {
    private final Logger LOGGER = LogManager.getLogger(ListenerDefault.class);

    public ListenerDefault() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.info(e);
    }
}
