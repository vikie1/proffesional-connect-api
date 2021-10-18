package io.github.vikie1.projectapi.tools.repository;

import io.github.vikie1.projectapi.tools.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Long> {
    boolean existsByName(String name);
    Tool findByName(String name);
}
