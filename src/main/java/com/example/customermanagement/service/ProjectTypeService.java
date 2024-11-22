package com.example.customermanagement.service;

import com.example.customermanagement.pojo.ProjectType;

import java.util.List;
import java.util.Optional;

public interface ProjectTypeService {
    List<ProjectType> getAllProjectTypes();
    Optional<ProjectType> getProjectTypeById(Integer projectTypeId);
    ProjectType createProjectType(ProjectType projectType);
    ProjectType updateProjectType(Integer projectTypeId, ProjectType projectType);
    void deleteProjectType(Integer projectTypeId);
}

