package io.github.vikie1.projectapi.util;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.users.entity.Users;

public record UserRecord(Users users, Location location, Skill skill) {}
