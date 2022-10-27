package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.enums.Color;
import by.tc.task01.service.validation.FeatureValidator;

public class ColorValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            Color.valueOf((String) value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
