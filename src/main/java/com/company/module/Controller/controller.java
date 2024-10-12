package com.company.module.Controller;

import com.company.module.Service.service;
import com.company.module.model.empinfo;
import com.company.module.model.interviewinfo;
import com.company.module.model.projectinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class controller {

    @Autowired
    private service s;

    @PostMapping("/{projectid}/emp")
    public ResponseEntity<empinfo> addemp(@PathVariable int projectid, @RequestBody empinfo emp){
        return new ResponseEntity<>(s.addemp(projectid, emp), HttpStatus.CREATED);
    }

    @PostMapping("/addproject")
    public ResponseEntity<projectinfo> addproject(@RequestBody projectinfo pro){
        return new ResponseEntity<>(s.addpro(pro), HttpStatus.CREATED);
    }

    @PostMapping("/{empid}/addinterview")
    public ResponseEntity<interviewinfo> addinterview(@PathVariable int empid, @RequestBody interviewinfo inv){
        return new ResponseEntity<>(s.addinv(empid, inv), HttpStatus.CREATED);
    }

    @GetMapping("/findemp/{id}")
    public ResponseEntity<empinfo> findemp(@PathVariable int id){
        return new ResponseEntity<>(s.findemp(id), HttpStatus.OK);
    }

    @GetMapping("/findproject/{id}")
    public ResponseEntity<projectinfo> findproject(@PathVariable int id){
        return new ResponseEntity<>(s.findpro(id), HttpStatus.OK);
    }

    @GetMapping("/findinterview/{id}")
    public ResponseEntity<interviewinfo> findinterview(@PathVariable int id){
        return new ResponseEntity<>(s.findinv(id), HttpStatus.OK);
    }

    @GetMapping("/findempbyproject/{projectid}")
    public ResponseEntity<List<empinfo>> findempbyproject(@PathVariable int projectid){
        return new ResponseEntity<>(s.findempbyproject(projectid), HttpStatus.OK);
    }

    @GetMapping("/empFailedinInterview/{projectid}")
    public ResponseEntity<List<empinfo>> findempbyinterview(@PathVariable int projectid){
        return new ResponseEntity<>(s.findempbyinterview(projectid), HttpStatus.OK);
    }
}
