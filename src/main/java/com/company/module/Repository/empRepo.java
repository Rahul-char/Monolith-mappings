package com.company.module.Repository;

import com.company.module.model.empinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empRepo extends JpaRepository<empinfo, Integer> {
}
