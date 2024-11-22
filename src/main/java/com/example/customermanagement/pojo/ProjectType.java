package com.example.customermanagement.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "project_type")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectTypeID")
    private Integer projectTypeId;

    @Column(name = "projectTypeName")
    private String projectTypeName;

    public Integer getProjectTypeId() {
        return this.projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return this.projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }
}
