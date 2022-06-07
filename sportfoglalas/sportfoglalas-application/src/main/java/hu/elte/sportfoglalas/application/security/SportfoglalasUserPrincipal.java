package hu.elte.sportfoglalas.application.security;

import hu.elte.sportfoglalas.domain.User;
import hu.elte.sportfoglalas.domain.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SportfoglalasUserPrincipal implements UserDetails {

    final private User user;

    public SportfoglalasUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user.getUserType() == UserType.JATEKOS ? Role.ROLE_JATEKOS : Role.ROLE_COACH);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
    public boolean isEnabled() {
        return true;
    }
}
