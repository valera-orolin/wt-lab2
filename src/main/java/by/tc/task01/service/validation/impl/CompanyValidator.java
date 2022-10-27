package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.enums.Company;
import by.tc.task01.service.validation.FeatureValidator;

public class CompanyValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            Company.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
