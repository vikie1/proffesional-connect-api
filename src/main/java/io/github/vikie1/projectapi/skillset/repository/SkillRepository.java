package io.github.vikie1.projectapi.skillset.repository;

import io.github.vikie1.projectapi.skillset.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findBySkillSet(String skillSet);
    boolean existsBySkillSet(String skillSet);
}
