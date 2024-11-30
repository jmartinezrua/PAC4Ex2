// File: `src/main/java/edu/uoc/pac4/university/UniversityException.java`
package edu.uoc.pac4.university;

public class UniversityException extends Exception {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";
    public static final String INVALID_ABBREVIATION = "[ERROR] Abbreviation has to contain between 2 and 6 uppercase letters";
    public static final String INVALID_FOUNDATION_DATE = "[ERROR] Foundation date cannot be null or in the future";
    public static final String INVALID_ADDRESS = "[ERROR] Address cannot be null";
    public static final String INVALID_WEBSITE = "[ERROR] Website cannot be null and must be a valid URL";

    public UniversityException(String message) {
        super(message);
    }
}