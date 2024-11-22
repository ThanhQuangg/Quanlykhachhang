package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.Classification;
import com.example.customermanagement.repository.ClassificationRepository;
import com.example.customermanagement.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public List<Classification> getAllClassifications() {
        return classificationRepository.findAll();
    }

    @Override
    public Optional<Classification> getClassificationById(Integer classificationId) {
        return classificationRepository.findById(classificationId);
    }

    @Override
    public Classification createClassification(Classification classification) {
        LocalDateTime currentTime = LocalDateTime.now();
//        classification.setCreatedAt(currentTime);
//        classification.setUpdatedAt(currentTime);
        return classificationRepository.save(classification);
    }

    @Override
    public Classification updateClassification(Integer classificationId, Classification classification) {
        Optional<Classification> existingClassification = classificationRepository.findById(classificationId);
        if (existingClassification.isPresent()) {
            Classification updatedClassification = existingClassification.get();
            updatedClassification.setClassificationName(classification.getClassificationName());
            updatedClassification.setCriteria(classification.getCriteria());

//          updatedClassification.setUpdatedAt(LocalDateTime.now());

            return classificationRepository.save(updatedClassification);
        } else {
            throw new RuntimeException("Classification not found");
        }
    }


    @Override
    public void deleteClassification(Integer classificationId) {
        classificationRepository.deleteById(classificationId);
    }
}

