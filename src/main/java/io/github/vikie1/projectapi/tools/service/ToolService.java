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
    public Tool getTool(Tool tool){ return getTool(tool.getTool()); }
    public Tool getTool(String toolName){ return toolRepository.findByName(toolName); }
}
