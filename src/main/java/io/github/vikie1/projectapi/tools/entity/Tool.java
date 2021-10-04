package io.github.vikie1.projectapi.tools.entity;

import javax.persistence.*;

@Entity
public class Tool {

    @Id @GeneratedValue @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String tool;

    public Tool(String tool){ this.tool = tool; }
    public Tool(){}

    public String getTool() { return tool; }
    public Long getId() { return id; }

    public void setTool(String tool) { this.tool = tool; }
    public void setId(Long id) { this.id = id; }
}
