package com.example.customermanagement.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "classification")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classificationID")
    private Integer classificationId;

    @Column(name = "classificationName")
    private String classificationName;

    @Column(name = "criteria")
    private String criteria;

    public Integer getClassificationId() {
        return this.classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return this.classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getCriteria() {
        return this.criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}
