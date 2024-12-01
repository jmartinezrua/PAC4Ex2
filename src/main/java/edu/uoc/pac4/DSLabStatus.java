package edu.uoc.pac4;

/**
 * Enum representing the status of a DSLab.
 */
public enum DSLabStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    MAINTENANCE("Maintenance");

    private final String status;

    /**
     * Constructor for DSLabStatus.
     *
     * @param status the status string
     */
    DSLabStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the status string.
     *
     * @return the status string
     */
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[" + status.toUpperCase() + "]";
    }
}
