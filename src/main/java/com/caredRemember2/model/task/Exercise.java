package com.caredRemember2.model.task;

import com.caredRemember2.model.Model;

/**
 * This Exercise.
 */
public class Exercise implements Model {
    private final String name;
    private String description;
    private String question = "This default string for question.";

    public Exercise(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return this.question;
    }

    public void sayAnswer(String answer) {

    }

    public boolean hasNextQuestion() {
        return true;
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
