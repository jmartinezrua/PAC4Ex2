package edu.uoc.pac4.activity;

public class ActivityProgrammingPython extends ActivityProgramming {
    private String pythonVersion;
    private boolean usesVirtualEnv;

    public ActivityProgrammingPython(String name, String description, double weight, String pythonVersion, boolean usesVirtualEnv) throws ActivityException {
        super(name, description, weight);
        setPythonVersion(pythonVersion);
        this.usesVirtualEnv = usesVirtualEnv;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }

    public void setPythonVersion(String pythonVersion) throws ActivityException {
        if (pythonVersion == null || !pythonVersion.matches("\\d+(\\.\\d+){0,2}")) {
            throw new ActivityException("[ERROR] Python version must be in the format x.y.z where z is optional");
        }
        this.pythonVersion = pythonVersion;
    }

    public boolean getUsesVirtualEnv() {
        return usesVirtualEnv;
    }

    public void setUsesVirtualEnv(boolean usesVirtualEnv) {
        this.usesVirtualEnv = usesVirtualEnv;
    }

    @Override
    public String toString() {
        return String.format("[Python] %s: %s%nTotal executions: %d (%.1f%%) (%s, %s)",
                getName(), getDescription(), getExecutions().size(), getWeight(),
                pythonVersion, usesVirtualEnv ? "with virtualenv" : "without virtualenv");
    }
}