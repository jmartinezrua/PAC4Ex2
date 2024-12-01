package edu.uoc.pac4.execution;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.ActivityQuiz;
import edu.uoc.pac4.user.Student;
import java.util.Locale;

/**
 * Class representing the execution of an activity by a student.
 */
public class Execution {
    private double score;
    private Student student;
    private Activity activity;

    /**
     * Constructs a new Execution.
     *
     * @param score    the score of the execution
     * @param student  the student who performed the execution
     * @param activity the activity being executed
     */
    public Execution(double score, Student student, Activity activity) {
        setScore(score);
        this.student = student;
        this.activity = activity;
        this.student.addExecution(this);
        this.activity.addExecution(this);
    }

    /**
     * Gets the score of the execution.
     *
     * @return the score of the execution
     */
    public double getScore() {
        return score;
    }

    /**
     * Sets the score of the execution.
     *
     * @param score the score to set
     */
    public void setScore(double score) {
        if (score < 0.0) {
            this.score = 0.0;
        } else if (score > 10.0) {
            this.score = 10.0;
        } else {
            this.score = score;
        }
    }

    /**
     * Gets the student who performed the execution.
     *
     * @return the student who performed the execution
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student who performed the execution.
     *
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets the activity being executed.
     *
     * @return the activity being executed
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Sets the activity being executed.
     *
     * @param activity the activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Returns a string representation of the execution.
     *
     * @return a string representing the execution
     */
    @Override
    public String toString() {
        return String.format(Locale.US, "[STUDENT] %s %s (%s) Total executions: %d%n%s%nTotal executions: %d%n%s%nScore: %.1f",
                student.getName(), student.getSurname(), student.getEmail(), student.getExecutions().size(),
                activity.getName() + ": " + activity.getDescription(), activity.getExecutions().size(),
                activity instanceof ActivityQuiz ? ((ActivityQuiz) activity).getType().toString() : "", score);
    }
}
