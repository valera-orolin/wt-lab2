package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.ApplianceNameConstants;
import by.tc.task01.service.validation.FeatureValidator;

public class ApplianceNameValidator implements FeatureValidator {
    @Override
    public boolean isCriteriaValid(Object value) {
        try {
            switch ((String) value) {
                case ApplianceNameConstants.LAPTOP:
                case ApplianceNameConstants.TEAPOT:
                case ApplianceNameConstants.FRIDGE:
                case ApplianceNameConstants.ALL:
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
