package com.company.module.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class empinfo {

    @Id
    private int empid;
    private String empname;
    private String empemail;
    private String empphone;

    @ManyToOne
    @JsonBackReference
    private projectinfo project;

    @OneToOne(mappedBy = "emp",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private interviewinfo interview;

}
