package com.company.module.Repository;

import com.company.module.model.interviewinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface interviewRepo extends JpaRepository<interviewinfo, Integer> {
}
