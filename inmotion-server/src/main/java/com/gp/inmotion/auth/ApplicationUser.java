package com.gp.inmotion.auth;

import com.gp.inmotion.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {
    private Long id;
    private String email;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser(Long id, String email,
                           String password,
                           Set<? extends GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.email = email;
    }

    public static ApplicationUser create(User user){
        return new ApplicationUser(
                user.getId(), user.getEmail(),
                user.getPassword(),
                user.getRole().getName().getGrantedAuthorities()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return email.split("@")[0];
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { return true; }

}
