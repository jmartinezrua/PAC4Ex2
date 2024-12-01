package edu.uoc.pac4.user;

import edu.uoc.pac4.execution.Execution;
import java.util.LinkedList;

/**
 * Class representing a student, extending the User class.
 */
public class Student extends User {
    private LinkedList<Execution> executions;

    /**
     * Constructs a new Student.
     *
     * @param email    the email of the student
     * @param name     the name of the student
     * @param surname  the surname of the student
     * @throws UserException if the email, name, or surname is invalid
     */
    public Student(String email, String name, String surname) throws UserException {
        super(email, name, surname);
        this.executions = new LinkedList<>();
    }

    /**
     * Adds an execution to the student's list of executions.
     *
     * @param execution the execution to add
     */
    public void addExecution(Execution execution) {
        this.executions.add(execution);
    }

    /**
     * Gets the list of executions of the student.
     *
     * @return the list of executions
     */
    public LinkedList<Execution> getExecutions() {
        return executions;
    }

    /**
     * Gets the last execution submitted by the student.
     *
     * @return the last execution submitted
     */
    public Execution getLastExecutionSubmitted() {
        return executions.getLast();
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a string representing the student
     */
    @Override
    public String toString() {
        return String.format("[STUDENT] %s %s (%s) Total executions: %d", getName(), getSurname(), getEmail(), executions.size());
    }
}
