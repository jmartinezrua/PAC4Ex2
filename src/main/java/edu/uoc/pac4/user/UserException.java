package edu.uoc.pac4.user;

public class UserException extends Exception {
    public static final String INVALID_EMAIL = "[ERROR] The email must start with any character end with @uoc.edu";
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";

    public UserException(String message) {
        super(message);
    }
}