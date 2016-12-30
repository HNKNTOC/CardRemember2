package com.caredRemember2.model;

/**
 * This Exercise.
 */
public class Exercise implements Model {
    private final String name;
    private final String description;

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
