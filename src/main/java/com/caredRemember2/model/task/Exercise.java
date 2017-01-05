package com.caredRemember2.model.task;

import com.caredRemember2.model.Model;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This Exercise.
 */
public class Exercise implements Model {
    private static final Logger LOGGER = LogManager.getLogger(Exercise.class);
    private final String name;
    /**
     * This list card Words for exercise.
     * Use for created question and check answer.
     */
    private final List<CardWord> cardWords;
    private String description;
    private String question = "Translate ";
    /**
     * This CardWords at which asks the question.
     */
    private CardWord nowCardWord;
    private boolean hasNextQuestion = false;
    private Iterator<CardWord> cardWordIterator;

    public Exercise(String name) {
        this(name, StorageCardWorld.getAllCardWords());
    }

    public Exercise(String name, List<CardWord> cardWords) {
        this.name = name;
        this.cardWords = cardWords;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Use for get all question, to answer them and set in {@link Exercise#handlingAnswer(Iterator)}.
     *
     * @return Iterator<Question> for to answer them.
     */
    public Iterator<Question> getAllQuestion() {
        List<Question> questions = new ArrayList<>();
        for (CardWord cardWord : cardWords) {
            questions.add(new Question(question));
        }
        return questions.iterator();
    }

    public void handlingAnswer(Iterator<Question> iterator) {

    }

    /**
     * For amenities get answer on question.
     * Use for receipt of the question and records answer for future handling.
     */
    public class Question {
        private final String question;
        private String answer;

        public Question(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }
    }
}
