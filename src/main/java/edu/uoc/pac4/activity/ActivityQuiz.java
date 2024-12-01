package edu.uoc.pac4.activity;

/**
 * Class representing a quiz activity.
 */
public class ActivityQuiz extends Activity {
    private ActivityQuizType type;

    /**
     * Constructs a new ActivityQuiz.
     *
     * @param name        the name of the activity
     * @param description the description of the activity
     * @param type        the type of the quiz
     * @throws ActivityException if the name or description is invalid
     */
    public ActivityQuiz(String name, String description, ActivityQuizType type) throws ActivityException {
        super(name, description);
        setType(type);
    }

    /**
     * Gets the type of the quiz.
     *
     * @return the type of the quiz
     */
    public ActivityQuizType getType() {
        return type;
    }

    /**
     * Sets the type of the quiz.
     *
     * @param type the type of the quiz
     */
    public void setType(ActivityQuizType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), type.toString());
    }
}
