package com.company.module.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class projectinfo {

    private String projectname;
    @Id
    private int projectid;
    private String projecttechnology;

    @OneToMany(mappedBy = "project",  cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<empinfo> emp;


}
