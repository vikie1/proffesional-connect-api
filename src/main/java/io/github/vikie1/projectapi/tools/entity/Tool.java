package io.github.vikie1.projectapi.tools.entity;

import javax.persistence.*;

@Entity
public class Tool {

    @Id @GeneratedValue @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;

    public Tool(String tool){ setTool(tool); }
    public Tool(){}

    public String getTool() { return name.toLowerCase(); }
    public Long getId() { return id; }

    public void setTool(String tool) { this.name = tool.toLowerCase(); }
    public void setId(Long id) { this.id = id; }
}
