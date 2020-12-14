package com.gp.inmotion.security;


import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Table;
import java.util.Set;
import java.util.stream.Collectors;

import static com.gp.inmotion.security.ApplicationUserPermission.*;

@Table
public enum ApplicationUserRole {
    PATIENT(Sets.newHashSet(PATIENT_READ)),
    THERAPIST(Sets.newHashSet(PATIENT_READ, PATIENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;
    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
