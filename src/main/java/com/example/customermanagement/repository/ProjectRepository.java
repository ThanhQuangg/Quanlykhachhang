package com.example.customermanagement.repository;

import com.example.customermanagement.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByCustomerId(Integer customerId);
}
