package com.gp.inmotion.auth;

import com.gp.inmotion.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {
    private String email;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser(String email,
                           String password,
                           Set<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.email = email;
    }

    public static ApplicationUser create(User user){
        return new ApplicationUser(
                user.getEmail(),
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

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return email;
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
