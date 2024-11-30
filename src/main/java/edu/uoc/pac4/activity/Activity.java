package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution; // Add this import statement
import java.util.LinkedList;

public abstract class Activity implements Cloneable {
    private String name;
    private String description;
    private LinkedList<Execution> executions = new LinkedList<>();

    public Activity(String name, String description) throws ActivityException {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ActivityException {
        if (name == null || name.trim().isEmpty()) {
            throw new ActivityException(ActivityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description.trim();
    }

    public void addExecution(Execution execution) {
        executions.add(execution);
    }

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
        return name + ": " + description + " Total executions: " + executions.size();
    }
}