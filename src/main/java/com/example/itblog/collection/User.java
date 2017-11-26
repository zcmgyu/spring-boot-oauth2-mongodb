package com.example.itblog.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Document(collection = "User")
public class User implements UserDetails {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Indexed(unique = true)
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private boolean enabled;

    private List<Role> roles;

    public User() {
    }

//    public User(String name, String username, String email, String password, boolean enabled) {
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.enabled = enabled;
//    }

    public User(User user) {
        super();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
