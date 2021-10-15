package io.github.vikie1.projectapi.tools.entity;

import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.users.entity.Users;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tool {

    @Id @GeneratedValue @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;

    //JOINS
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "users_id")
    private Users owner;

    @ManyToMany(mappedBy = "tools", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Project> projects;

    public Tool(String tool){ setTool(tool); }
    public Tool(){}

    public Users getOwner() { return owner; }
    public String getTool() { return name.toLowerCase(); }
    public Long getId() { return id; }

    public void setOwner(Users owner) { this.owner = owner; }
    public void setTool(String tool) { this.name = tool.toLowerCase(); }
    public void setId(Long id) { this.id = id; }
}
