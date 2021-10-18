package io.github.vikie1.projectapi.util;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.location.service.LocationService;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.posts.service.ProjectService;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.skillset.service.SkillService;
import io.github.vikie1.projectapi.tools.entity.Tool;
import io.github.vikie1.projectapi.tools.service.ToolService;
import io.github.vikie1.projectapi.users.entity.Authorities;
import io.github.vikie1.projectapi.users.entity.Users;
import io.github.vikie1.projectapi.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstructEntities {
    @Autowired
    LocationService locationService;
    @Autowired
    UsersService usersService;
    @Autowired
    SkillService skillService;
    @Autowired
    ToolService toolService;
    @Autowired
    ProjectService projectService;

     public void locAndUser(UserRecord record, Set<Authorities> authorities){
         if (record == null) return;
         locationService.add(record.location());
         skillService.save(record.skill());
         Set<Skill> skill = new HashSet<>();
         skill.add(skillService.getSkill(record.skill()));
         Location newLocation = locationService.get(record.location());
         Users users = record.users();
         users.setAuthorities(authorities);
         users.setLocation(newLocation);
         users.setSkills(skill);
         usersService.createAccount(users);
     }
     public void post(Post post){
         if (post==null || post.skill() == null) return;
         Users user = usersService.get(post.account().getUsername());
         if (user == null) return;
         assert post.location() != null;
         locationService.add(post.location());
         Location location = locationService.get(post.location());
         Set<Skill> skills = new HashSet<>();
         for (Skill skill: post.skill()) {
             skillService.save(skill);
             skills.add(skillService.getSkill(skill));
         }
         Set<Tool> tools = new HashSet<>();
         for (Tool tool: post.tools()) {
             tool.setOwner(user);
             toolService.save(tool);
             tools.add(toolService.getTool(tool));
         }
         Project project = post.project();
         project.setUser(user);
         project.setLocation(location);
         project.setSkills(skills);
         project.setTools(tools);
         projectService.add(project);
     }
}
