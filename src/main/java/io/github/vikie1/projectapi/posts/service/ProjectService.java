package io.github.vikie1.projectapi.posts.service;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.posts.repository.ProjectRepository;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.users.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    //CREATE
    public void add(Project project){ projectRepository.save(project); }

    //READ
    public List<Project> getBySkill(Skill skill){ return new ArrayList<>(projectRepository.findBySkills(skill)); }
    public List<Project> getLocationSpecific(Skill skill, Location location){
        return new ArrayList<>(projectRepository.findBySkillsAndLocation(skill, location));
    }
    public List<Project> getFromUser(Users user){ return new ArrayList<>(projectRepository.findByUser(user)); }
}
