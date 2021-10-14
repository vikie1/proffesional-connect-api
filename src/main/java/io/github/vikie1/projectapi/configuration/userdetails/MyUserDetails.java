package io.github.vikie1.projectapi.configuration.userdetails;

import io.github.vikie1.projectapi.users.entity.Authorities;
import io.github.vikie1.projectapi.users.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private Users users;
    public MyUserDetails(){}
    public MyUserDetails(Users user){
        setUsers(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority;
        List<SimpleGrantedAuthority> authoritiesList = null;
        for (Authorities role: users.getAuthorities() ) {
            authoritiesList = new ArrayList<>();
            simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoles());
            authoritiesList.add(simpleGrantedAuthority);
        }
        return authoritiesList;
    }
    @Override
    public String getPassword() { return users.getPassword(); }
    @Override
    public String getUsername() { return users.getUsername(); }
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return users.getEnabled(); }


    public Users getUsers() { return users; }
    public void setUsers(Users users) { this.users = users; }
}
