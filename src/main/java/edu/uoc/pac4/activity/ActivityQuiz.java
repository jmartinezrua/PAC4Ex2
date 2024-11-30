// ActivityQuiz.java
package edu.uoc.pac4.activity;

public class ActivityQuiz extends Activity {
    private ActivityQuizType type;

    public ActivityQuiz(String name, String description, ActivityQuizType type) throws ActivityException {
        super(name, description);
        this.type = type;
    }

    public ActivityQuizType getType() {
        return type;
    }

    public void setType(ActivityQuizType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " " + type.toString();
    }
}
