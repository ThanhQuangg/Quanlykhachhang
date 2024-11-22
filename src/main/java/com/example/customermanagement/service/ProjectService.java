package com.example.customermanagement.service;

import com.example.customermanagement.pojo.Project;
import java.util.List;
import java.util.Optional;

    public interface ProjectService {
        List<Project> getAllProjects();
        List<Project> getProjectsByCustomerId(Integer customerId);
        Optional<Project> getProjectById(Integer projectId);
        Project createProject(Project project);
        Project updateProject(Integer projectId, Project project);
        void deleteProject(Integer projectId);
    }


