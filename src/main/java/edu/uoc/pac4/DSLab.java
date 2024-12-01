package edu.uoc.pac4;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.Evaluable;
import edu.uoc.pac4.university.University;
import edu.uoc.pac4.DSLabStatus;
import edu.uoc.pac4.user.User;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents a DSLab with various attributes and methods to manage its state and related entities.
 */
public class DSLab {
    public static final long MIN_CPU_REQUIRED = 1073741824L;
    private String name;
    private String description;
    private int versionMajor;
    private int versionMinor;
    private int versionPatch;
    private long cpu;
    private University university;
    private DSLabStatus status;
    private LinkedList<User> users = new LinkedList<>();
    private LinkedList<Activity> activities = new LinkedList<>();
    private LinkedList<Evaluable> evaluableActivities = new LinkedList<>();

    /**
     * Constructs a new DSLab.
     *
     * @param name         the name of the DSLab
     * @param description  the description of the DSLab
     * @param versionMajor the major version number
     * @param versionMinor the minor version number
     * @param versionPatch the patch version number
     * @param cpu          the CPU capacity
     * @param university   the associated university
     * @throws DSLabException if any parameter is invalid
     */
    public DSLab(String name, String description, int versionMajor, int versionMinor, int versionPatch, long cpu, University university) throws DSLabException {
        setName(name);
        setDescription(description);
        setVersionMajor(versionMajor);
        setVersionMinor(versionMinor);
        setVersionPatch(versionPatch);
        setCpu(cpu);
        setUniversity(university);
        this.status = DSLabStatus.ACTIVE;
    }

    /**
     * Gets the name of the DSLab.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the DSLab.
     *
     * @param name the new name
     * @throws DSLabException if the name is null or empty
     */
    public void setName(String name) throws DSLabException {
        if (name == null || name.trim().isEmpty()) {
            throw new DSLabException(DSLabException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    /**
     * Gets the description of the DSLab.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the DSLab.
     *
     * @param description the new description
     * @throws DSLabException if the description is null
     */
    public void setDescription(String description) throws DSLabException {
        if (description == null) {
            throw new DSLabException(DSLabException.INVALID_DESCRIPTION);
        }
        this.description = description;
    }

    /**
     * Gets the version of the DSLab in the format major.minor.patch.
     *
     * @return the version
     */
    public String getVersion() {
        return versionMajor + "." + versionMinor + "." + versionPatch;
    }

    /**
     * Gets the major version number.
     *
     * @return the major version number
     */
    public int getVersionMajor() {
        return versionMajor;
    }

    /**
     * Sets the major version number.
     *
     * @param versionMajor the new major version number
     * @throws DSLabException if the major version number is negative
     */
    public void setVersionMajor(int versionMajor) throws DSLabException {
        if (versionMajor < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_MAJOR);
        }
        this.versionMajor = versionMajor;
    }

    /**
     * Gets the minor version number.
     *
     * @return the minor version number
     */
    public int getVersionMinor() {
        return versionMinor;
    }

    /**
     * Sets the minor version number.
     *
     * @param versionMinor the new minor version number
     * @throws DSLabException if the minor version number is negative
     */
    public void setVersionMinor(int versionMinor) throws DSLabException {
        if (versionMinor < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_MINOR);
        }
        this.versionMinor = versionMinor;
    }

    /**
     * Gets the patch version number.
     *
     * @return the patch version number
     */
    public int getVersionPatch() {
        return versionPatch;
    }

    /**
     * Sets the patch version number.
     *
     * @param versionPatch the new patch version number
     * @throws DSLabException if the patch version number is negative
     */
    public void setVersionPatch(int versionPatch) throws DSLabException {
        if (versionPatch < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_PATCH);
        }
        this.versionPatch = versionPatch;
    }

    /**
     * Gets the CPU capacity.
     *
     * @return the CPU capacity
     */
    public long getCpu() {
        return cpu;
    }

    /**
     * Sets the CPU capacity.
     *
     * @param cpu the new CPU capacity
     * @throws DSLabException if the CPU capacity is below the minimum required
     */
    public void setCpu(long cpu) throws DSLabException {
        if (cpu < MIN_CPU_REQUIRED) {
            throw new DSLabException(DSLabException.NO_ENOUGH_CPU);
        }
        this.cpu = cpu;
    }

    /**
     * Gets the associated university.
     *
     * @return the university
     */
    public University getUniversity() {
        return university;
    }

    /**
     * Sets the associated university.
     *
     * @param university the new university
     * @throws DSLabException if the university is null
     */
    public void setUniversity(University university) throws DSLabException {
        if (university == null) {
            throw new DSLabException(DSLabException.UNIVERSITY_NULL);
        }
        this.university = university;
    }

    /**
     * Gets the status of the DSLab.
     *
     * @return the status
     */
    public DSLabStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the DSLab.
     *
     * @param status the new status
     */
    public void setStatus(DSLabStatus status) {
        this.status = status;
    }

    /**
     * Adds a user to the DSLab.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Gets the list of users.
     *
     * @return the list of users
     */
    public LinkedList<User> getUsers() {
        return users;
    }

    /**
     * Adds an activity to the DSLab.
     *
     * @param activity the activity to add
     */
    public void addActivity(Activity activity) {
        this.activities.add(activity);
        if (activity instanceof Evaluable) {
            this.evaluableActivities.add((Evaluable) activity);
        }
    }

    /**
     * Gets the list of activities.
     *
     * @return the list of activities
     */
    public LinkedList<Activity> getActivities() {
        return activities;
    }

    /**
     * Gets the list of evaluable activities.
     *
     * @return the list of evaluable activities
     */
    public LinkedList<Evaluable> getEvaluableActivities() {
        return evaluableActivities;
    }

    @Override
    public String toString() {
        return name + System.lineSeparator() +
                "\tDescription: " + description + System.lineSeparator() +
                "\tVersion: " + getVersion() + System.lineSeparator() +
                "\tStatus: " + status + System.lineSeparator() +
                "\tCPU: " + cpu + System.lineSeparator() +
                "\tUniversity: " + university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DSLab dsLab = (DSLab) o;
        return versionMajor == dsLab.versionMajor &&
                versionMinor == dsLab.versionMinor &&
                versionPatch == dsLab.versionPatch &&
                Objects.equals(name, dsLab.name) &&
                Objects.equals(university, dsLab.university);
    }
}
