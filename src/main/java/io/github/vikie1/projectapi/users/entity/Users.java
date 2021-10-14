package io.github.vikie1.projectapi.users.entity;

import io.github.vikie1.projectapi.posts.entity.Project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
    Set<Authorities> authorities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    Set<Project> projects;

    public Users(){}
    public Users(String username, String password, String email) {
        setEnabled();
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public Set<Authorities> getAuthorities() {return authorities;}
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getUsername() { return username; }
    public Long getId() { return id; }
    public boolean getEnabled() { return enabled; }

    public void setAuthorities(Set<Authorities> authorities) { this.authorities = authorities; }
    public void setId(Long id) { this.id = id; }
    public void setEnabled() { this.enabled = true; }
    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
}
