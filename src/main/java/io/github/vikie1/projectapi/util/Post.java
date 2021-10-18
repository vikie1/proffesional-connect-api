package io.github.vikie1.projectapi.util;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.posts.entity.Project;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.tools.entity.Tool;
import io.github.vikie1.projectapi.users.entity.Users;

import java.util.List;

public record Post(Location location, List<Skill> skill, Project project, List<Tool> tools, Users account) {}
