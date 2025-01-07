package com.example.register1;



import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CompanyDTO {
	
	@NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Details cannot be blank")
    @Size(max = 500, message = "Details must not exceed 500 characters")
    private String details;

    @NotEmpty(message = "Directors list cannot be empty")
    @NoDuplicates(message = "Directors list must not contain duplicate names")
    private List<@NotBlank(message = "Director name cannot be blank") String> directors;


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }
}
