package com.gp.inmotion.security;

public enum ApplicationUserPermission {
    PATIENT_READ("patient:read"),
    PATIENT_WRITE("patient:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

