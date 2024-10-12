package com.company.module.Service;

import com.company.module.Repository.empRepo;
import com.company.module.Repository.interviewRepo;
import com.company.module.Repository.projectRepo;
import com.company.module.model.empinfo;
import com.company.module.model.interviewinfo;
import com.company.module.model.projectinfo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.*;


@Service
public class service {

    @Autowired
    private empRepo er;
    @Autowired
    private projectRepo pr;
    @Autowired
    private interviewRepo ir;

    public empinfo addemp(int projectid,empinfo emp) {
        Optional<projectinfo> p1 = pr.findById(projectid);
        if(p1.isPresent()) {
            projectinfo p = p1.get();
            emp.setProject(p);
            return er.save(emp);
        }else{
            throw new EntityNotFoundException("project not found with id: " + projectid);
        }
    }

    public projectinfo addpro(projectinfo pro) {
        return pr.save(pro);
    }

    public interviewinfo addinv(int empid, interviewinfo inv) {
        Optional<empinfo> e1 = er.findById(empid);
        if(e1.isPresent()) {
            empinfo e = e1.get();
            inv.setEmp(e);
            return ir.save(inv);
        }else{
            throw new EntityNotFoundException("emp not found with id: " + empid);
        }
    }

    public empinfo findemp(int id) {
        return er.findById(id).get();
    }

    public projectinfo findpro(int id) {
        return pr.findById(id).get();
    }

    public interviewinfo findinv(int id) {
        return ir.findById(id).get();
    }

    public List<empinfo> findempbyproject(int projectid) {
        List<empinfo> p = er.findAll().stream()
                    .filter(x -> x.getProject().getProjectid() == projectid)
                    .collect(Collectors.toList());
        return p;
    }

    public List<empinfo> findempbyinterview(int projectid) {
        return er.findAll().stream()
                .filter(x -> !x.getInterview().getStatus())
                .filter(x -> x.getProject().getProjectid() == projectid)
                .collect(Collectors.toList());
    }
}
