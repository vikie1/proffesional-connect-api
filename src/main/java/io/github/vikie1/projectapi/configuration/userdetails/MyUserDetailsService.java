package io.github.vikie1.projectapi.configuration.userdetails;

import io.github.vikie1.projectapi.users.entity.Users;
import io.github.vikie1.projectapi.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);
        if (user.isPresent()) return new MyUserDetails(user.get());
        else throw new UsernameNotFoundException("Could not find user: '" + username + "'");
    }
}
