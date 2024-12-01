package edu.uoc.pac4.activity;

/**
 * Enum representing the different types of quiz activities.
 */
public enum ActivityQuizType {
    /**
     * A quiz type with multiple choice questions.
     */
    MULTIPLE_CHOICE("Collection of questions with multiple choices"),
    
    /**
     * A quiz type with true or false questions.
     */
    TRUE_FALSE("Collection of questions with true or false answers"),
    
    /**
     * A quiz type with short answer questions.
     */
    SHORT_ANSWER("Collection of questions with short answers");

    private final String description;

    /**
     * Constructs an ActivityQuizType with the given description.
     *
     * @param description the description of the quiz type
     */
    ActivityQuizType(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the quiz type.
     *
     * @return the description of the quiz type
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
