package com.caredRemember2.model.task;

/**
 * TODO: Add doc
 * Created by Nikita on 05.01.2017.
 */
public class CardWord {
    private static int idCounter = 0;
    private int id = idCounter;
    private final String foreignWord;
    private final String translateWord;

    public CardWord(String foreignWord, String translateWord) {
        this.foreignWord = foreignWord;
        this.translateWord = translateWord;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public String getTranslateWord() {
        return translateWord;
    }

    @Override
    public String toString() {
        return "CardWord{" +
                "foreignWord='" + foreignWord + '\'' +
                ", translateWord='" + translateWord + '\'' +
                '}';
    }
}
