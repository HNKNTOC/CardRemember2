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
    private final List<Exercise.Question> questions;
    private String description;
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
     * Use for get all question, to answer them and set in {@link Exercise#endsAnswerOnAllQuestion()}.
     *
     * @return List<Question> for to answer them.
     */
    private List<Question> createQuestions() {
        LOGGER.debug("createQuestions()");
        List<Question> questions = new ArrayList<>();
        for (CardWord cardWord : cardWords) {
            Question question = new Question(cardWord);
            questions.add(question);
            LOGGER.debug("createQuestions: Create and add " + question);
        }
        return questions;
    }

    /**
     * Call after as {@link Exercise#questionIterator} hasNext() return false.
     * Call this method means what all questions put answer.
     */
    public void endsAnswerOnAllQuestion() {
        if (!questionIterator.hasNext()) {
            LOGGER.debug("endsAnswerOnAllQuestion: go");
            for (Exercise.Question question : questions) {
                question.endsAnswer();
            }
        } else {
            LOGGER.warn("Use endsAnswerOnAllQuestion() when hasNext() not false. Call after as hasNext() return false.");
        }
    }

    /**
     * For amenities get answer on question.
     * Use for receipt of the question and records answer for future handling.
     */
    public class Question {
        private final static String QUESTION = "Translate ";
        /**
         * Question which need the answer.
         */
        private final String question;
        /**
         * Use for put answer call {@link CardWord#sayAnswer(String)}.
         */
        private final CardWord cardWord;
        /**
         * Answer for the question.
         * Need for to check answer.
         */
        private String answer;

        /**
         * Create Question.
         *
         * @param cardWord {@link CardWord} for which need create {@link Question}.
         */
        public Question(CardWord cardWord) {
            this.question = createQuestion(cardWord);
            this.cardWord = cardWord;
        }

        private String createQuestion(CardWord cardWord) {
            return QUESTION + cardWord.getForeignWord();
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

        @Override
        public String toString() {
            return "Question{" +
                    ", answer='" + answer + '\'' +
                    '}';
        }

        /**
         * The final answer.
         * {@link Question} put answer in {@link CardWord}.
         */
        public void endsAnswer() {
            LOGGER.debug("endsAnswer: " + answer);
            cardWord.sayAnswer(answer);
        }
    }
}
