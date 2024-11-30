package edu.uoc.pac4;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.Evaluable;
import edu.uoc.pac4.university.University;
import edu.uoc.pac4.DSLabStatus;
import edu.uoc.pac4.user.User;

import java.util.LinkedList;
import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) throws DSLabException {
        if (name == null || name.trim().isEmpty()) {
            throw new DSLabException(DSLabException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws DSLabException {
        if (description == null) {
            throw new DSLabException(DSLabException.INVALID_DESCRIPTION);
        }
        this.description = description;
    }

    public String getVersion() {
        return versionMajor + "." + versionMinor + "." + versionPatch;
    }

    public int getVersionMajor() {
        return versionMajor;
    }

    public void setVersionMajor(int versionMajor) throws DSLabException {
        if (versionMajor < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_MAJOR);
        }
        this.versionMajor = versionMajor;
    }

    public int getVersionMinor() {
        return versionMinor;
    }

    public void setVersionMinor(int versionMinor) throws DSLabException {
        if (versionMinor < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_MINOR);
        }
        this.versionMinor = versionMinor;
    }

    public int getVersionPatch() {
        return versionPatch;
    }

    public void setVersionPatch(int versionPatch) throws DSLabException {
        if (versionPatch < 0) {
            throw new DSLabException(DSLabException.INVALID_VERSION_PATCH);
        }
        this.versionPatch = versionPatch;
    }

    public long getCpu() {
        return cpu;
    }

    public void setCpu(long cpu) throws DSLabException {
        if (cpu < MIN_CPU_REQUIRED) {
            throw new DSLabException(DSLabException.NO_ENOUGH_CPU);
        }
        this.cpu = cpu;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) throws DSLabException {
        if (university == null) {
            throw new DSLabException(DSLabException.UNIVERSITY_NULL);
        }
        this.university = university;
    }

    public DSLabStatus getStatus() {
        return status;
    }

    public void setStatus(DSLabStatus status) {
        this.status = status;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public LinkedList<Activity> getActivities() {
        return activities;
    }

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