package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.ProjectType;
import com.example.customermanagement.repository.ProjectTypeRepository;
import com.example.customermanagement.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Override
    public List<ProjectType> getAllProjectTypes() {
        return projectTypeRepository.findAll();
    }

    @Override
    public Optional<ProjectType> getProjectTypeById(Integer projectTypeId) {
        return projectTypeRepository.findById(projectTypeId);
    }

    @Override
    public ProjectType createProjectType(ProjectType projectType) {
        return projectTypeRepository.save(projectType);
    }

    @Override
    public ProjectType updateProjectType(Integer projectTypeId, ProjectType projectType) {
        Optional<ProjectType> existingProjectType = projectTypeRepository.findById(projectTypeId);
        if (existingProjectType.isPresent()) {
            ProjectType updatedProjectType = existingProjectType.get();
            updatedProjectType.setProjectTypeName(projectType.getProjectTypeName());
            return projectTypeRepository.save(updatedProjectType);
        } else {
            throw new RuntimeException("Project Type not found");
        }
    }

    @Override
    public void deleteProjectType(Integer projectTypeId) {
        projectTypeRepository.deleteById(projectTypeId);
    }
}

