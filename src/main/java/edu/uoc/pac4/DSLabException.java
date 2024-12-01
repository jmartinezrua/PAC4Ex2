package edu.uoc.pac4;

/**
 * Custom exception class for DSLab-related errors.
 */
public class DSLabException extends Exception {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";
    public static final String INVALID_DESCRIPTION = "[ERROR] Description cannot be null";
    public static final String INVALID_VERSION_MAJOR = "[ERROR] Major version cannot be negative";
    public static final String INVALID_VERSION_MINOR = "[ERROR] Minor version cannot be negative";
    public static final String INVALID_VERSION_PATCH = "[ERROR] Patch version cannot be negative";
    public static final String NO_ENOUGH_CPU = "[ERROR] This server does not have enough CPU";
    public static final String UNIVERSITY_NULL = "[ERROR] University cannot be null";

    /**
     * Constructs a new DSLabException with the specified detail message.
     *
     * @param message the detail message
     */
    public DSLabException(String message) {
        super(message);
    }
}
