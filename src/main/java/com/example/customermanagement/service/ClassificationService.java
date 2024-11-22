package com.example.customermanagement.service;

import com.example.customermanagement.pojo.Classification;

import java.util.List;
import java.util.Optional;

public interface ClassificationService {
    List<Classification> getAllClassifications();
    Optional<Classification> getClassificationById(Integer classificationId);
    Classification createClassification(Classification classification);
    Classification updateClassification(Integer classificationId,Classification classification);
    void deleteClassification(Integer classificationId);
}

