package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import java.util.LinkedList;

/**
 * Abstract class representing an Activity.
 */
public abstract class Activity implements Cloneable {
    private String name;
    private String description;
    private LinkedList<Execution> executions;

    /**
     * Constructs a new Activity.
     *
     * @param name        the name of the activity
     * @param description the description of the activity
     * @throws ActivityException if the name is invalid
     */
    public Activity(String name, String description) throws ActivityException {
        setName(name);
        setDescription(description);
        this.executions = new LinkedList<>();
    }

    /**
     * Gets the name of the activity.
     *
     * @return the name of the activity
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the activity.
     *
     * @param name the new name of the activity
     * @throws ActivityException if the name is null or empty
     */
    public void setName(String name) throws ActivityException {
        if (name == null || name.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    /**
     * Gets the description of the activity.
     *
     * @return the description of the activity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the activity.
     *
     * @param description the new description of the activity
     */
    public void setDescription(String description) {
        if (description == null) {
            this.description = "";
        } else {
            this.description = description.trim();
        }
    }

    /**
     * Adds an execution to the activity.
     *
     * @param execution the execution to add
     */
    public void addExecution(Execution execution) {
        this.executions.add(execution);
    }

    /**
     * Gets the list of executions.
     *
     * @return the list of executions
     */
    public LinkedList<Execution> getExecutions() {
        return executions;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Activity cloned = (Activity) super.clone();
        cloned.executions = new LinkedList<>();
        return cloned;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%nTotal executions: %d", name, description, executions.size());
    }
}
