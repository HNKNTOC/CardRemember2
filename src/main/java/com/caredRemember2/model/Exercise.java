package com.caredRemember2.model;

/**
 * This Exercise.
 */
public class Exercise implements Model {
    private final String name;
    private String description;
    private String question = "";

    public Exercise(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return this.question;
    }

    public void sayAnsver(String answer) {

    }

    public boolean hasNextQuestion() {
        return false;
    }

    public void nextQuestion() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
