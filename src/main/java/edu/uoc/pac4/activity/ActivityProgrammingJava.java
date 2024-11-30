package edu.uoc.pac4.activity;

public class ActivityProgrammingJava extends ActivityProgramming {
    private String jdkVersion;
    private String gradleVersion;

    public ActivityProgrammingJava(String name, String description, double weight, String jdkVersion, String gradleVersion) throws ActivityException {
        super(name, description, weight);
        setJdkVersion(jdkVersion);
        setGradleVersion(gradleVersion);
    }

    public String getJdkVersion() {
        return jdkVersion;
    }

    public void setJdkVersion(String jdkVersion) throws ActivityException {
        if (jdkVersion == null || !jdkVersion.matches("\\d+(\\.\\d+){0,2}")) {
            throw new ActivityException(ActivityException.INVALID_JDK_VERSION);
        }
        this.jdkVersion = jdkVersion;
    }

    public String getGradleVersion() {
        return gradleVersion;
    }


    public void setGradleVersion(String gradleVersion) throws ActivityException {
        if (gradleVersion == null || !gradleVersion.matches("\\d+(\\.\\d+){1,2}")) {
            throw new ActivityException(ActivityException.INVALID_GRADLE_VERSION);
        }
        this.gradleVersion = gradleVersion;
    }

    @Override
    public String toString() {
        return "[Java] " + super.toString() + " (jdk-" + jdkVersion + ", gradle v" + gradleVersion + ")";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}