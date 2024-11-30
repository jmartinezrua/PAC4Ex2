package edu.uoc.pac4.activity;

import java.util.Locale;

public class ActivityProgrammingPython extends ActivityProgramming {
    private String pythonVersion;
    private boolean usesVirtualEnv;

    public ActivityProgrammingPython(String name, String description, double weight, String pythonVersion, boolean usesVirtualEnv) throws ActivityException {
        super(name, description, weight);
        setPythonVersion(pythonVersion);
        setUsesVirtualEnv(usesVirtualEnv);
    }

    public String getPythonVersion() {
        return pythonVersion;
    }


    public void setPythonVersion(String pythonVersion) throws ActivityException {
        if (pythonVersion == null || !pythonVersion.matches("\\d+(\\.\\d+){1,2}")) {
            throw new ActivityException(ActivityException.INVALID_PYTHON_VERSION);
        }
        this.pythonVersion = pythonVersion;
    }

    public boolean getUsesVirtualEnv() {
        return usesVirtualEnv;
    }

    public void setUsesVirtualEnv(boolean usesVirtualEnv) {
        this.usesVirtualEnv = usesVirtualEnv;
    }

    /*@Override
    public String toString() {
        return String.format(Locale.US, "[Python] %s (%.1f%%) (%s, with virtualenv%s)",
                super.toString(), getWeight(), pythonVersion, usesVirtualEnv ? "" : " not");
    }*/

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