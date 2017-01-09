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
    private final static String QUESTION = "Translate ";
    private final String name;
    /**
     * This list card Words for exercise.
     * Use for created question and check answer.
     */
    private final List<CardWord> cardWords;
    private String description;
    private final List<Exercise.Question> questions;
    private Iterator<Exercise.Question> questionIterator;

    public Exercise(String name) {
        this(name, StorageCardWord.getAllCardWords());
    }

    public Exercise(String name, List<CardWord> cardWords) {
        this.name = name;
        this.cardWords = cardWords;
        this.questions = createQuestions();
        this.questionIterator = questions.iterator();
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

    public Iterator<Question> getQuestionIterator() {
        return questionIterator;
    }

    /**
     * Use for get all question, to answer them and set in {@link Exercise#handlingAnswer()}.
     *
     * @return List<Question> for to answer them.
     */
    private List<Question> createQuestions() {
        LOGGER.debug("createQuestions()");
        List<Question> questions = new ArrayList<>();
        for (CardWord cardWord : cardWords) {
            Question question = new Question(
                    QUESTION + cardWord.getForeignWord(),
                    cardWord.getId()
            );
            questions.add(question);
            LOGGER.debug("createQuestions: Create and add " + question);
        }
        return questions;
    }

    /**
     * Handling need use after as {@link Exercise#questionIterator} hasNext() return false.
     * This method handling answer and records result.
     */
    public void handlingAnswer() {
        if (!questionIterator.hasNext()) {
            LOGGER.debug("handlingAnswer: go");
            for (Exercise.Question question : questions) {
                LOGGER.debug("handlingAnswer: Answer - " + question.getAnswer());
            }
        } else {
            LOGGER.fatal("handlingAnswer: Use when hasNext() not false. Need hasNext() return false.");
        }
    }

    /**
     * For amenities get answer on question.
     * Use for receipt of the question and records answer for future handling.
     */
    public class Question {
        /**
         * Question which need the answer.
         */
        private final String question;
        /**
         * Use for find CardWord.
         */
        private final int idCardWord;
        /**
         * Answer for the question.
         * Need for to check answer.
         */
        private String answer;

        public Question(String question, int idCardWord) {
            this.question = question;
            this.idCardWord = idCardWord;
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

        public int getIdCardWord() {
            return idCardWord;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "question='" + question + '\'' +
                    ", answer='" + answer + '\'' +
                    ", idCardWord=" + idCardWord +
                    '}';
        }
    }
}
