package io.github.vikie1.projectapi.users.entity;

import javax.persistence.*;

@Entity
public class Authorities {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String roles;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "users_id")
    private Users users;

    public Authorities(){}
    public Authorities(String roles){ setRoles(roles); }

    public Long getId() { return id; }
    public String getRoles() { return roles; }
    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
    public void setRoles(String roles) { this.roles = roles; }
    public void setId(Long id) { this.id = id; }
}
