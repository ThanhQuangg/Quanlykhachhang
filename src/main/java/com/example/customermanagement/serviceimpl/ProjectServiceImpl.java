package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.Project;
import com.example.customermanagement.repository.ProjectRepository;
import com.example.customermanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProjectById(Integer projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectsByCustomerId(Integer customerId) {
        return projectRepository.findByCustomerId(customerId);
    }

    @Override
    public Project createProject(Project project) {
        LocalDateTime currentTime = LocalDateTime.now();
        project.setCreatedAt(currentTime);
        project.setUpdatedAt(currentTime);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Integer projectId, Project project) {
        Optional<Project> existingProject = projectRepository.findById(projectId);
        if (existingProject.isPresent()) {
            Project updatedProject = existingProject.get();

            updatedProject.setProjectName(project.getProjectName());
            updatedProject.setDescription(project.getDescription());
            updatedProject.setStartDate(project.getStartDate());
            updatedProject.setEndDate(project.getEndDate());
            updatedProject.setStatus(project.getStatus());
            updatedProject.setProjectType(project.getProjectType());
            updatedProject.setPaymentId(project.getPaymentId());

            // Chỉ cập nhật updatedAt, không thay đổi createdAt
            updatedProject.setUpdatedAt(LocalDateTime.now());

            return projectRepository.save(updatedProject);
        } else {
            throw new RuntimeException("Project not found");
        }
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}

