package com.caredRemember2.model.task;

/**
 * TODO: Add doc
 * Created by Nikita on 05.01.2017.
 */
public class CardWord {
    public final String foreignWord;
    public final String translateWord;

    public CardWord(String foreignWord, String translateWord) {
        this.foreignWord = foreignWord;
        this.translateWord = translateWord;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public String getTranslateWord() {
        return translateWord;
    }
}
