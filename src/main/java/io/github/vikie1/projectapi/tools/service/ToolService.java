package io.github.vikie1.projectapi.tools.service;

import io.github.vikie1.projectapi.tools.entity.Tool;
import io.github.vikie1.projectapi.tools.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToolService {

    @Autowired
    ToolRepository toolRepository;

    //CREATE
    public void save(String toolName){ save(new Tool(toolName)); }
    public void save(Tool tool){
        if (!toolRepository.existsByName(tool.getTool()))
            toolRepository.save(tool);
    }

    //READ
    public List<Tool> getTool(Tool tool){ return new ArrayList<>(getTool(tool.getTool())); }
    public List<Tool> getTool(String toolName){ return new ArrayList<>(toolRepository.findByName(toolName)); }
}
