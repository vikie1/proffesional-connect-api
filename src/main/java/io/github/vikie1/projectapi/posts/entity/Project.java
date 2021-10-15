package io.github.vikie1.projectapi.posts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.tools.entity.Tool;
import io.github.vikie1.projectapi.users.entity.Users;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Project {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(columnDefinition = "text", length = 1000)
    private String post;

    //JOINS
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "skills_id"))
    private Set<Skill> skills;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_tools",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "tools_id"))
    private Set<Tool> tools;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "users_id")
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "location_id")
    private Location location;

    public Project(){}
    public Project(String post, Set<Skill> skill, Users user, Location location) {
        setSkills(skill);
        setPost(post);
        setUser(user);
        setLocation(location);
    }

    public String getPost() { return post; }
    public Set<Skill> getSkills() { return skills; }
    public Location getLocation() { return location; }
    public Set<Tool> getTools() { return tools; }
    @JsonIgnore
    public Long getId() { return id; }
    @JsonIgnore
    public Users getUser() { return user; }

    public void setLocation(Location location) { this.location = location; }
    public void setSkills(Set<Skill> skills) { this.skills = skills; }
    public void setId(Long id) { this.id = id; }
    public void setPost(String post) { this.post = post; }
    public void setUser(Users user) { this.user = user; }
}
