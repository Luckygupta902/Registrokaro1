package com.example.register1;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DirectorRepository directorRepository;
    
    
    public CompanyService(CompanyRepository companyRepository, DirectorRepository directorRepository) {
        this.companyRepository = companyRepository;
        this.directorRepository = directorRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }
    
    public Company saveCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setName(companyDTO.getName());
        company.setDetails(companyDTO.getDetails());

        // Add directors to the company
        List<Director> directors = companyDTO.getDirectors().stream()
            .map(directorName -> {
                Director director = new Director();
                director.setName(directorName);
                director.setCompany(company);
                return director;
            })
            .collect(Collectors.toList());
       

        company.setDirectors(directors);

        // Save company and directors
        return companyRepository.save(company);
    }
    // Fetch all companies
    public List<Company> getAllCompanies1() {
        return companyRepository.findAll();
    }

    // Fetch a company by ID with its directors
    public Company getCompanyById1(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    // Fetch directors for a specific company
    public List<Director> getDirectorsByCompanyId(Long companyId) {
        return directorRepository.findByCompanyId(companyId);
    }
}

