package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.enums.OS;
import by.tc.task01.service.validation.FeatureValidator;

public class OSValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            OS.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
