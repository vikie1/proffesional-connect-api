package io.github.vikie1.projectapi.controller.rest;

import io.github.vikie1.projectapi.location.service.LocationService;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.posts.service.ProjectService;
import io.github.vikie1.projectapi.skillset.service.SkillService;
import io.github.vikie1.projectapi.users.service.UsersService;
import io.github.vikie1.projectapi.util.ConstructEntities;
import io.github.vikie1.projectapi.util.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectsController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UsersService usersService;
    @Autowired
    SkillService skillService;
    @Autowired
    LocationService locationService;

    //GET
    @GetMapping("/skill/{name}")
    public HashMap<String, List<Project>> get(@PathVariable String skillName){
        HashMap<String, List<Project>> response = new HashMap<>();
        response.put(skillName, projectService.getBySkill(skillService.getSkill(skillName)));
        return response;
    }
    @GetMapping("/skill/{name}/at/{city}/{country}")
    public HashMap<String, List<Project>> get(@PathVariable String name, @PathVariable String city, @PathVariable String country){
        HashMap<String, List<Project>> response = new HashMap<>();
        response.put(name, projectService.getLocationSpecific(skillService.getSkill(name),
                locationService.get(city, country)));
        return response;
    }
    @GetMapping("/user/{name}")
    public HashMap<String, List<Project>> getTimeline(@PathVariable String username){
        HashMap<String, List<Project>> response = new HashMap<>();
        response.put(username, projectService.getFromUser(usersService.get(username)));
        return response;
    }

    //POST
    @PostMapping("/new")
    public void post(@RequestBody Post post){
        ConstructEntities constructor = new ConstructEntities();
        constructor.post(post);
    }

}
