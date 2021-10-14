package io.github.vikie1.projectapi.users.service;

import io.github.vikie1.projectapi.users.entity.Authorities;
import io.github.vikie1.projectapi.users.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesService {
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    //CREATE
    public void create(Authorities authorities){ authoritiesRepository.save(authorities); }
    public void create(List<Authorities> authorities) { authoritiesRepository.saveAll(authorities); }

    //READ
    public Authorities get(Authorities authority){ return authoritiesRepository.findByRoles(authority.getRoles()); }
    public boolean existsByRole(String role) { return authoritiesRepository.existsByRoles(role); }
}
