package edu.uoc.pac4.university;

/**
 * Exception class for representing university-related errors.
 */
public class UniversityException extends Exception {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";
    public static final String INVALID_ABBREVIATION = "[ERROR] Abbreviation has to contain between 2 and 6 uppercase letters";
    public static final String INVALID_FOUNDATION_DATE = "[ERROR] Foundation date cannot be null or in the future";
    public static final String INVALID_ADDRESS = "[ERROR] Address cannot be null";
    public static final String INVALID_WEBSITE = "[ERROR] Website cannot be null and must be a valid URL";

    /**
     * Constructs a new UniversityException with the specified detail message.
     *
     * @param message the detail message
     */
    public UniversityException(String message) {
        super(message);
    }
}
