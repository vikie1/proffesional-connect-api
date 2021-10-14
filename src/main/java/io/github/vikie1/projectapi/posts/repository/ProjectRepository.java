package io.github.vikie1.projectapi.posts.repository;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findBySkills(Skill skill);
    List<Project> findByUser(Users user);
    List<Project> findBySkillsAndLocation(Skill skill, Location location);
}
