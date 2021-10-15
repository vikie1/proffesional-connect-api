package io.github.vikie1.projectapi.users.service;

import io.github.vikie1.projectapi.configuration.security.UsersConfiguration;
import io.github.vikie1.projectapi.error.ResourceNotFoundError;
import io.github.vikie1.projectapi.users.entity.Authorities;
import io.github.vikie1.projectapi.users.entity.Users;
import io.github.vikie1.projectapi.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersConfiguration usersConfiguration;
    @Autowired
    AuthoritiesService authorityService;

    //CREATE
    public void createAccount(Users users){
        users.setPassword(usersConfiguration.encoder().encode(users.getPassword()));
        Authorities[] givenAuthorities = users.getAuthorities().toArray(Authorities[]::new);
        Set<Authorities> authoritiesList = new HashSet<>();
        for (Authorities authority: givenAuthorities) {
            if (!authorityService.existsByRole(authority.getRoles())) authorityService.create(authority);
            authoritiesList.add(authorityService.get(authority));
        }
        users.setAuthorities(authoritiesList);
        usersRepository.save(users);
    }

    //READ
    public Users get(String username){
        Optional<Users> user = usersRepository.findByUsername(username);
        if (user.isPresent()) return user.get();
        else throw new ResourceNotFoundError("Account '" + username + "' doesn't exist");
    }
}
