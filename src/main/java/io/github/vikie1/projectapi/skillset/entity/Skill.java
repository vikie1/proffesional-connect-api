package io.github.vikie1.projectapi.skillset.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.vikie1.projectapi.posts.entity.Project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Skill {

    @Id @GeneratedValue @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String skillSet;
    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Project> projects;

    public Skill(String skillSet) { setSkillSet(skillSet); }
    public Skill(){}

    @JsonIgnore
    public String getSkillSet() { return skillSet.toLowerCase(); }
    public Long getId() { return id; }

    public void setSkillSet(String skillSet) { this.skillSet = skillSet.toLowerCase(); }
    public void setId(Long id) { this.id = id; }
}
