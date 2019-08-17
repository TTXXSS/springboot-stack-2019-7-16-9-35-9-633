package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable long id){
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping
    public void deleteCompany(){
       companyService.deleteCompany();
    }

}
