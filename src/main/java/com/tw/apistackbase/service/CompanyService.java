package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(){
        companyRepository.deleteAll();
    }

    public Company getCompanyById(long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        return null;
    }

    public void deleteCompanyById(long id){
        companyRepository.deleteById(id);
    }

    public List<Company> getCompanyByPage(int pageNum,int pageSize){
        Pageable pageable= (Pageable) PageRequest.of(pageNum-1,pageSize);
        Page<Company> page=companyRepository.findAll(pageable);
        return page.getContent();
    }
}
