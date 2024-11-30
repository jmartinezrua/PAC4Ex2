package edu.uoc.pac4.activity;

public class ActivityQuiz extends Activity {
    private ActivityQuizType type;

    public ActivityQuiz(String name, String description, ActivityQuizType type) throws ActivityException {
        super(name, description);
        setType(type);
    }

    public ActivityQuizType getType() {
        return type;
    }

    public void setType(ActivityQuizType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), type.toString());
    }
}
