package com.company.module.Repository;

import com.company.module.model.projectinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepo extends JpaRepository<projectinfo, Integer> {
}
