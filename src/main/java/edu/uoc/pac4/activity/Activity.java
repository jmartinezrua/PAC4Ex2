package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import java.util.LinkedList;

public abstract class Activity implements Cloneable {
    private String name;
    private String description;
    private LinkedList<Execution> executions;

    public Activity(String name, String description) throws ActivityException {
        setName(name);
        setDescription(description);
        this.executions = new LinkedList<>();
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
        if (description == null) {
            this.description = "";
        } else {
            this.description = description.trim();
        }
    }

    public void addExecution(Execution execution) {
        this.executions.add(execution);
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
        return String.format("%s: %s%nTotal executions: %d", name, description, executions.size());
    }
}