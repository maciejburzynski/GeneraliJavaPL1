package pl.generali.Spring.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.generali.Spring.security.UserPermission.*;

public enum UserRole {
    SUPER_ADMIN(Set.of(REST_API_WRITE, REST_API_READ, TOKEN_READ)),
    ADMIN(Set.of(REST_API_WRITE, REST_API_READ, TOKEN_READ)),
    USER(Set.of(TOKEN_READ));

    Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
