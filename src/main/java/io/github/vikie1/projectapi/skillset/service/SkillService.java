package io.github.vikie1.projectapi.skillset.service;

import io.github.vikie1.projectapi.skillset.entity.Skill;
import io.github.vikie1.projectapi.skillset.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    //CREATE
    public void save(String skill){ save(new Skill(skill)); }
    public void save(Skill skill){
        if ( !skillRepository.existsBySkillSet(skill.getSkillSet()))
            skillRepository.save(skill);
    }

    //READ
    public List<Skill> getSkill(String skill){ return getSkill(new Skill(skill)); }
    public List<Skill> getSkill(Skill skill){
        return new ArrayList<Skill>(skillRepository.findBySkillSet(skill.getSkillSet()));
    }

    //UPDATE (I don't think its needed but assuming correction of spelling mistake could be a thing)
    public void update(Skill skill){
        if (skillRepository.existsById(skill.getId()))
            skillRepository.save(skill);
    }

    //DELETE
    public void deleteById(Long id){ skillRepository.deleteById(id); }
    public void deleteSkill(Skill skill){ skillRepository.delete(skill); }
}
