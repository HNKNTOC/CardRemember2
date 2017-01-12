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
     * Word of a foreign.
     */
    private final String foreignWord;
    /**
     * Word of a translate.
     */
    private final String translateWord;
    /**
     * Unique id.
     */
    private int id = idCounter;
    /**
     * Use for definition bad minded word.
     */
    private int ratingMemorize;

    public CardWord(String foreignWord, String translateWord) {
        this.foreignWord = foreignWord;
        this.translateWord = translateWord;
        idCounter++;
    }

    /**
     * Use, if to forgot word.
     */
    private void forgot() {
        ratingMemorize--;
    }

    /**
     * Use, if to remember word.
     */
    private void remember() {
        ratingMemorize++;
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

    public int getRatingMemorize() {
        return ratingMemorize;
    }

    public void sayAnswer(String answer) {
        if (translateWord.equals(answer)) {
            remember();
        } else {
            forgot();
        }
    }

    @Override
    public String toString() {
        return "CardWord{" +
                "id=" + id +
                ", foreignWord='" + foreignWord + '\'' +
                ", translateWord='" + translateWord + '\'' +
                ", ratingMemorize=" + ratingMemorize +
                '}';
    }
}
