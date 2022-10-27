package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.enums.CPU;
import by.tc.task01.service.validation.FeatureValidator;

public class CPUValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            CPU.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}