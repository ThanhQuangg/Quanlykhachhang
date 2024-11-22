package com.example.customermanagement.controller;

import com.example.customermanagement.pojo.ProjectType;
import com.example.customermanagement.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project-types")
public class ProjectTypeController {

    @Autowired
    private ProjectTypeService projectTypeService;

    @GetMapping
    public List<ProjectType> getAllProjectTypes() {
        return projectTypeService.getAllProjectTypes();
    }

    @GetMapping("/{projectTypeId}")
    public ResponseEntity<ProjectType> getProjectTypeById(@PathVariable Integer projectTypeId) {
        Optional<ProjectType> projectType = projectTypeService.getProjectTypeById(projectTypeId);
        return projectType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjectType> createProjectType(@RequestBody ProjectType projectType) {
        ProjectType createdProjectType = projectTypeService.createProjectType(projectType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjectType);
    }

    @PutMapping("/{projectTypeId}")
    public ResponseEntity<ProjectType> updateProjectType(@PathVariable Integer projectTypeId, @RequestBody ProjectType projectType) {
        ProjectType updatedProjectType = projectTypeService.updateProjectType(projectTypeId, projectType);
        return updatedProjectType != null ? ResponseEntity.ok(updatedProjectType) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{projectTypeId}")
    public ResponseEntity<Void> deleteProjectType(@PathVariable Integer projectTypeId) {
        projectTypeService.deleteProjectType(projectTypeId);
        return ResponseEntity.noContent().build();
    }
}
