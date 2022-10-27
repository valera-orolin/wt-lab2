package by.tc.task01.service.validation.impl;

import by.tc.task01.service.validation.FeatureValidator;

public class IntValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        if (value instanceof Integer) {
            return (Integer) value > 0;
        } else {
            return false;
        }
    }

}
