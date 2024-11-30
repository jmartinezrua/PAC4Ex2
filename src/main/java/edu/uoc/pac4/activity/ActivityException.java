package edu.uoc.pac4.activity;

public class ActivityException extends Exception {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, empty or blank";
    public static final String INVALID_CPP_COMPILER = "[ERROR] Compiler cannot be null, empty or blank";
    public static final String INVALID_CPP_STANDARD = "[ERROR] Standard cannot be null, empty or blank";
    public static final String INVALID_JDK_VERSION = "[ERROR] JDK version must be in the format x.y.z where y and z are optional";
    public static final String INVALID_GRADLE_VERSION = "[ERROR] Gradle version must be in the format x.y.z where z is optional";
    public static final String INVALID_PYTHON_VERSION = "[ERROR] Python version must be in the format x.y.z where z is optional";

    public ActivityException(String message) {
        super(message);
    }
}