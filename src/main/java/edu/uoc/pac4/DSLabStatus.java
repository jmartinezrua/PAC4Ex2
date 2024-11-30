package edu.uoc.pac4;

public enum DSLabStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    MAINTENANCE("Maintenance");

    private final String status;

    DSLabStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[" + status.toUpperCase() + "]";
    }
}