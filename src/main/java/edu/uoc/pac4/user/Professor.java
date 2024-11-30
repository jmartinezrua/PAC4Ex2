// Professor.java
package edu.uoc.pac4.user;

import edu.uoc.pac4.activity.Activity;
import java.util.LinkedList;

public class Professor extends User {
    private LinkedList<Activity> activities;

    public Professor(String email, String name, String surname) throws UserException {
        super(email, name, surname);
        this.activities = new LinkedList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public LinkedList<Activity> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return String.format("[PROFESSOR] %s %s (%s) Total activities: %d",
                getName(), getSurname(), getEmail(), getActivities().size());
    }
}