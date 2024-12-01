package edu.uoc.pac4.user;

/**
 * Exception class for representing user-related errors.
 */
public class UserException extends Exception {
    public static final String INVALID_EMAIL = "[ERROR] The email must start with any character end with @uoc.edu";
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";

    /**
     * Constructs a new UserException with the specified detail message.
     *
     * @param message the detail message
     */
    public UserException(String message) {
        super(message);
    }
}
