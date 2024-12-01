package edu.uoc.pac4.activity;

import java.util.Locale;

/**
 * Class representing a Python programming activity.
 */
public class ActivityProgrammingPython extends ActivityProgramming {
    private String pythonVersion;
    private boolean usesVirtualEnv;

    /**
     * Constructs a new ActivityProgrammingPython.
     *
     * @param name            the name of the activity
     * @param description     the description of the activity
     * @param weight          the weight of the activity
     * @param pythonVersion   the Python version to be used
     * @param usesVirtualEnv  whether the activity uses a virtual environment
     * @throws ActivityException if any parameter is invalid
     */
    public ActivityProgrammingPython(String name, String description, double weight, String pythonVersion, boolean usesVirtualEnv) throws ActivityException {
        super(name, description, weight);
        setPythonVersion(pythonVersion);
        setUsesVirtualEnv(usesVirtualEnv);
    }

    /**
     * Gets the Python version used for this activity.
     *
     * @return the Python version
     */
    public String getPythonVersion() {
        return pythonVersion;
    }

    /**
     * Sets the Python version for this activity.
     *
     * @param pythonVersion the Python version to set
     * @throws ActivityException if the Python version is null or invalid
     */
    public void setPythonVersion(String pythonVersion) throws ActivityException {
        if (pythonVersion == null || !pythonVersion.matches("\\d+(\\.\\d+){1,2}")) {
            throw new ActivityException(ActivityException.INVALID_PYTHON_VERSION);
        }
        this.pythonVersion = pythonVersion;
    }

    /**
     * Checks if the activity uses a virtual environment.
     *
     * @return true if the activity uses a virtual environment, false otherwise
     */
    public boolean getUsesVirtualEnv() {
        return usesVirtualEnv;
    }

    /**
     * Sets whether the activity uses a virtual environment.
     *
     * @param usesVirtualEnv true if the activity uses a virtual environment, false otherwise
     */
    public void setUsesVirtualEnv(boolean usesVirtualEnv) {
        this.usesVirtualEnv = usesVirtualEnv;
    }

    /**
     * Returns a string representation of the activity.
     *
     * @return a string representing the activity
     */
    @Override
    public String toString() {
        return String.format(Locale.US, "[Python] %s (%s, with virtualenv%s)",
                super.toString(), pythonVersion, usesVirtualEnv ? "" : " not");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
