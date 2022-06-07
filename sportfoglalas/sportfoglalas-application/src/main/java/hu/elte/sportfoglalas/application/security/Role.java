package hu.elte.sportfoglalas.application.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_JATEKOS, ROLE_ADMIN, ROLE_COACH;

    @Override
    public String getAuthority() {
        return name();
    }
}
