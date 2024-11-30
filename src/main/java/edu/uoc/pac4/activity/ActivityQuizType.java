// ActivityQuizType.java
package edu.uoc.pac4.activity;

public enum ActivityQuizType {
    MULTIPLE_CHOICE("Collection of questions with multiple choices"),
    TRUE_FALSE("Collection of questions with true or false answers"),
    SHORT_ANSWER("Collection of questions with short answers");

    private final String description;

    ActivityQuizType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}