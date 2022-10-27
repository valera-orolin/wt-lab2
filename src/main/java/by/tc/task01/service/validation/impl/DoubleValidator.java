package by.tc.task01.service.validation.impl;

import by.tc.task01.service.validation.FeatureValidator;

public class DoubleValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        if (value instanceof Double) {
            return (Double) value > 0;
        } else {
            return false;
        }
    }

}
