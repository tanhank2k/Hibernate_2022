package common;

public enum Status {
    ACTIVE,
    INACTIVE,
    DELETED,
    UNKNOWN;

    public static Status getStatus(String status) {
        if (status.equalsIgnoreCase("ACTIVE")) {
            return ACTIVE;
        } else if (status.equalsIgnoreCase("INACTIVE")) {
            return INACTIVE;
        } else if (status.equalsIgnoreCase("DELETED")) {
            return DELETED;
        } else {
            return UNKNOWN;
        }
    }
}
