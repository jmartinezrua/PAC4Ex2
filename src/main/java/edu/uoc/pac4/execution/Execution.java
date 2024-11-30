package edu.uoc.pac4.execution;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.ActivityQuiz;
import edu.uoc.pac4.user.Student;
import java.util.Locale;

public class Execution {
    private double score;
    private Student student;
    private Activity activity;

    public Execution(double score, Student student, Activity activity) {
        setScore(score);
        this.student = student;
        this.activity = activity;
        this.student.addExecution(this);
        this.activity.addExecution(this);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score < 0.0) {
            this.score = 0.0;
        } else if (score > 10.0) {
            this.score = 10.0;
        } else {
            this.score = score;
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[STUDENT] %s %s (%s) Total executions: %d%n%s%nTotal executions: %d%n%s%nScore: %.1f",
                student.getName(), student.getSurname(), student.getEmail(), student.getExecutions().size(),
                activity.getName() + ": " + activity.getDescription(), activity.getExecutions().size(),
                activity instanceof ActivityQuiz ? ((ActivityQuiz) activity).getType().toString() : "", score);
    }
}