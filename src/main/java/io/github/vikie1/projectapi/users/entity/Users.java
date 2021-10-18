package io.github.vikie1.projectapi.users.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.tools.entity.Tool;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean enabled;

    //JOINS
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
    Set<Authorities> authorities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    Set<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    Set<Skill> skills;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "users_id")
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    Set<Tool> tools;

    public Users(){}
    public Users(String fName, String lName,String username, String password, String email) {
        setEnabled();
        setFName(fName);
        setLName(lName);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public String getUsername() { return username; }
    public String getFName() { return fName; }
    public String getLName() { return lName; }
    public Set<Skill> getSkills() { return skills; }

    @JsonIgnore
    public Set<Project> getProjects() { return projects; }
    @JsonIgnore
    public Set<Authorities> getAuthorities() {return authorities;}
    @JsonIgnore
    public String getPassword() { return password; }
    @JsonIgnore
    public String getEmail() { return email; }
    @JsonIgnore
    public Long getId() { return id; }
    @JsonIgnore
    public boolean getEnabled() { return enabled; }

    public void setAuthorities(Set<Authorities> authorities) { this.authorities = authorities; }
    public void setId(Long id) { this.id = id; }
    public void setEnabled() { this.enabled = true; }
    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setFName(String fName) { this.fName = fName; }
    public void setLName(String lName) { this.lName = lName; }
    public void setLocation(Location location) { this.location = location; }
    public void setSkills(Set<Skill> skills) { this.skills = skills; }
}
