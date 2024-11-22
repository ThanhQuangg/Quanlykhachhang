package com.example.customermanagement.controller;

import com.example.customermanagement.pojo.Classification;
import com.example.customermanagement.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classifications")
public class ClassificationController {

    private final ClassificationService classificationService;

    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @GetMapping
    public List<Classification> getAllClassifications() {
        return classificationService.getAllClassifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classification> getClassificationById(@PathVariable Integer id) {
        Optional<Classification> classification = classificationService.getClassificationById(id);
        return classification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Classification createClassification(@RequestBody Classification classification) {
        return classificationService.createClassification(classification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classification> updateClassification(@PathVariable Integer id, @RequestBody Classification classificationDetails) {
        Classification updateClassification = classificationService.updateClassification(id, classificationDetails);
        return updateClassification != null ? ResponseEntity.ok(updateClassification) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassification(@PathVariable Integer id) {
        classificationService.deleteClassification(id);
        return ResponseEntity.noContent().build();
    }
}

