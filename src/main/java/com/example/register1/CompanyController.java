package com.example.register1;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/companies1")
    public ResponseEntity<Company> createCompany(@Validated @RequestBody CompanyDTO companyDTO) {
        Company savedCompany = companyService.saveCompany(companyDTO);
        return ResponseEntity.ok(savedCompany);
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/companies")
    public List<Company> getAllCompanies1() {
        return companyService.getAllCompanies();
    }

    // Fetch a company by ID
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/companies/{id}")
    public Company getCompanyById1(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    // Fetch directors of a company by company ID
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/companies/{id}/directors")
    public List<Director> getDirectorsByCompanyId(@PathVariable Long id) {
        return companyService.getDirectorsByCompanyId(id);
    }
}

