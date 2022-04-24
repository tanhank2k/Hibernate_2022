package common;

public enum Role {
    TEACHER,
    STUDENT;
    public static Role getRole(String role) {
        if (role.equals("Teacher")) {
            return Role.TEACHER;
        } else {
            return Role.STUDENT;
        }
    }
}
