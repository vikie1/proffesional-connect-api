package io.github.vikie1.projectapi.users.repository;

import io.github.vikie1.projectapi.users.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
    Authorities findByRoles(String roles);
    boolean existsByRoles(String roles);
}
