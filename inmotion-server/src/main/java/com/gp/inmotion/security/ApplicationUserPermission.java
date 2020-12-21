package com.gp.inmotion.security;

public enum ApplicationUserPermission {
    PATIENT_READ("patient:read"),
    PATIENT_WRITE("patient:write"),
    THERAPIST_READ("therapist:read"),
    THERAPIST_WRITE("therapist:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

