package com.company.module.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class interviewinfo {

    @Id
    private int interviewid;
    private boolean status;

    @OneToOne
    @JsonBackReference
    private empinfo emp;

    public boolean getStatus() {
        return status;
    }
}
