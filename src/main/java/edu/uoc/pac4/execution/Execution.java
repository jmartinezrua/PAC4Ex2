package edu.uoc.pac4.execution;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.user.Student;

public class Execution {
    private double score;
    private Student student;
    private Activity activity;

    public Execution(double score, Student student, Activity activity) {
        this.student = student;
        this.activity = activity;
        setScore(score);
        activity.addExecution(this);
        student.addExecution(this);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score < 0) {
            this.score = 0;
        } else if (score > 10) {
            this.score = 10;
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
        return student.toString() + " " + activity.toString() + " Score: " + score;
    }
}