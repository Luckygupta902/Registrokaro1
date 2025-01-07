package com.example.register1;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.List;

public class NoDuplicatesValidator implements ConstraintValidator<NoDuplicates, List<String>> {

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Valid since @NotEmpty handles empty check
        }
        return value.size() == new HashSet<>(value).size(); // Check for duplicates
    }
}

