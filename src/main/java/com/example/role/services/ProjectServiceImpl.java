package com.example.role.services;

import com.example.role.dtos.ProjectRequest;
import com.example.role.dtos.ProjectResponse;
import com.example.role.models.Project;
import com.example.role.repositories.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProjectResponse saveProject(ProjectRequest projectRequest) {
        if (projectRequest.getProjectDescription() == null) {
            throw new RuntimeException("Parameter project Desc not found in request");
        } else if (projectRequest.getProjectName() == null) {
            throw new RuntimeException("Parameter project name not found in request");
        }
        Project savedProject = null;
        if (projectRequest.getId() != null) {
            Project oldProject= projectRepository.findAllValid(projectRequest.getId());
            if (oldProject != null) {
                oldProject.setProjectName(projectRequest.getProjectName());
                oldProject.setProjectDescription(projectRequest.getProjectDescription());
                oldProject.setId(projectRequest.getId());
                savedProject = projectRepository.save(oldProject);
            } else {
                throw new RuntimeException("Cannot find faculty with identifier: " + projectRequest.getId());
            }

        } else {
            Project project = modelMapper.map(projectRequest, Project.class);
            savedProject = projectRepository.save(project);



        }
        ProjectResponse projectResponse = modelMapper.map(savedProject, ProjectResponse.class);
        return projectResponse;
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = (List<Project>) projectRepository.findByValidSortedCreated();
        Type listOfprojectsRes = new TypeToken<List<ProjectResponse>>() {
        }.getType();
        List<ProjectResponse> projectResponses = modelMapper.map(projects, listOfprojectsRes);
        return projectResponses;
    }

    @Override
    public ProjectResponse retire(Long id) {
        Project project = projectRepository.findAllValid(id);
        projectRepository.delete(project);
        ProjectResponse projectResponse =modelMapper.map(project, ProjectResponse.class);
        return projectResponse;

    }
}
