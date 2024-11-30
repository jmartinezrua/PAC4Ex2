package edu.uoc.pac4.user;

import edu.uoc.pac4.execution.Execution;
import java.util.LinkedList;

public class Student extends User {
    private LinkedList<Execution> executions = new LinkedList<>();

    public Student(String email, String name, String surname) throws UserException {
        super(email, name, surname);
    }

    public void addExecution(Execution execution) {
        executions.add(execution);
    }

    public LinkedList<Execution> getExecutions() {
        return executions;
    }

    public Execution getLastExecutionSubmitted() {
        return executions.getLast();
    }

    @Override
    public String toString() {
        return "[STUDENT] " + super.toString() + " Total executions: " + executions.size();
    }
}