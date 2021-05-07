package com.example.role.services;

import com.example.role.dtos.ProjectRequest;
import com.example.role.dtos.ProjectResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public interface ProjectService {

    ProjectResponse saveProject(ProjectRequest projectRequest);

    List<ProjectResponse> getAllProjects();

    ProjectResponse retire(Long id);
}
