package com.example.role.controllers;

import com.example.role.dtos.ProjectRequest;
import com.example.role.dtos.ProjectResponse;
import com.example.role.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(value = "/save")
    public ResponseEntity saveProject(@RequestBody ProjectRequest projectRequest) {

        ProjectResponse projectResponse = projectService.saveProject(projectRequest);
        return ResponseEntity.ok(projectResponse);
    }

    public ResponseEntity getAllProjects() {
        List<ProjectResponse> projectResponses = projectService.getAllProjects();
        return ResponseEntity.ok(projectResponses);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ProjectResponse> retire(@PathVariable("id") Long id) {

        ProjectResponse projectResponse = projectService.retire(id);
        return ResponseEntity.ok().body(projectResponse);
    }


}
