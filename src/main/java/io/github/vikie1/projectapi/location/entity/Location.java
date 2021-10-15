package io.github.vikie1.projectapi.location.entity;

import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.users.entity.Users;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {
    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    private String country;
    private String city;

    //JOINS
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
    Set<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL)
    Set<Users> users;

    public Location(){}
    public Location(String country, String city) {
        setCountry(country);
        setCity(city);
    }

    public Long getId() { return id; }
    public String getCountry() { return country; }
    public String getCity() { return city; }

    public void setId(Long id) { this.id = id; }
    public void setCountry(String country) { this.country = country; }
    public void setCity(String city) { this.city = city; }
}
