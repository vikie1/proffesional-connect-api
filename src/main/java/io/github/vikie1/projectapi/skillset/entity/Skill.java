package io.github.vikie1.projectapi.skillset.entity;

import javax.persistence.*;

@Entity
public class Skill {

    @Id @GeneratedValue @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String skillSet;

    public Skill(String skillSet) { this.skillSet = skillSet; }
    public Skill(){}

    public String getSkillSet() { return skillSet; }
    public Long getId() { return id; }

    public void setSkillSet(String skillSet) { this.skillSet = skillSet; }
    public void setId(Long id) { this.id = id; }
}