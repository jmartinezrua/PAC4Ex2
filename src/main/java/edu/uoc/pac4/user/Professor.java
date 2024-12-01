package edu.uoc.pac4.user;

import edu.uoc.pac4.activity.Activity;
import java.util.LinkedList;

/**
 * Class representing a professor, extending the User class.
 */
public class Professor extends User {
    private LinkedList<Activity> activities;

    /**
     * Constructs a new Professor.
     *
     * @param email    the email of the professor
     * @param name     the name of the professor
     * @param surname  the surname of the professor
     * @throws UserException if the email, name, or surname is invalid
     */
    public Professor(String email, String name, String surname) throws UserException {
        super(email, name, surname);
        this.activities = new LinkedList<>();
    }

    /**
     * Adds an activity to the professor's list of activities.
     *
     * @param activity the activity to add
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Gets the list of activities assigned to the professor.
     *
     * @return the list of activities
     */
    public LinkedList<Activity> getActivities() {
        return activities;
    }

    /**
     * Returns a string representation of the professor.
     *
     * @return a string representing the professor
     */
    @Override
    public String toString() {
        return String.format("[PROFESSOR] %s %s (%s) Total activities: %d",
                getName(), getSurname(), getEmail(), getActivities().size());
    }
}
