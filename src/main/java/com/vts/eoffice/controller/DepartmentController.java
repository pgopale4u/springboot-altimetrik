package com.vts.eoffice.controller;

import com.vts.eoffice.dto.DepartmentEmpDtls;
import com.vts.eoffice.dto.DepartmentProjectDtls;
import com.vts.eoffice.exception.DepartmentNotFoundException;
import com.vts.eoffice.model.Department;
import com.vts.eoffice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department dept){
        Department department = null;
        try {
            department = departmentService.save(dept);
        }catch(Exception ex){
            throw new RuntimeException("Exception occured while storing Department data");
        }
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartment(){
        List<Department> departmentList = null;
        try {
            departmentList =  departmentService.findAllDepartment();
        }catch (Exception ex){
            throw new RuntimeException("Exception occured while retrieving data from database");
        }
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

    @GetMapping("/{deptid}")
    public ResponseEntity<Department> findByDepartmentId(@PathVariable("deptid") String deptid){
         Department dept = null;
        try {
            dept = departmentService.findByDeptId(deptid);
        }catch(DepartmentNotFoundException ex){
            throw new DepartmentNotFoundException(ex.getMessage());
        }catch (Exception ex){
            throw new RuntimeException("Exception occured while retrieving data from database");
        }
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    @GetMapping("/empdtls/{deptid}")
    public ResponseEntity<DepartmentEmpDtls> findAllEmployessByDepartment(@PathVariable("deptid") String deptid){
        DepartmentEmpDtls departmentEmpDtls = null;
        try {
            departmentEmpDtls = departmentService.findAllEmployessByDepartment(deptid);
        }catch (Exception ex){
            throw new RuntimeException("Exception occured while retrieving data from database");
        }
        return new ResponseEntity<>(departmentEmpDtls, HttpStatus.OK);
    }

    @GetMapping("/projects/{deptid}")
    public ResponseEntity<DepartmentProjectDtls> findAllProjectsByDepartment(@PathVariable("deptid") String deptid){
        DepartmentProjectDtls departmentProjectDtls = null;
        try {
            departmentProjectDtls = departmentService.findAllProjectsByDepartment(deptid);
        }catch (Exception ex){
            throw new RuntimeException("Exception occured while retrieving data from database");
        }
        return  new ResponseEntity<>(departmentProjectDtls, HttpStatus.OK);
    }

}
