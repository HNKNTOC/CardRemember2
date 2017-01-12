package com.caredRemember2.model.task;

/**
 * Contain data about world.
 * Set each CardWord unique {@link CardWord#id}.
 */
public class CardWord {
    /**
     * Use for get unique id for CardWord.
     * Increment when create new object CardWord.
     */
    private static int idCounter = 0;
    /**
     * Unique id.
     */
    private int id = idCounter;
    /**
     * Word of a foreign.
     */
    private final String foreignWord;
    /**
     * Word of a translate.
     */
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
