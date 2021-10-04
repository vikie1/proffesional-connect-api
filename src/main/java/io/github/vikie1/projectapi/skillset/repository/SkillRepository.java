package io.github.vikie1.projectapi.skillset.repository;

import io.github.vikie1.projectapi.skillset.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
