package by.tc.task01.service.validation;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.impl.*;

import java.util.HashMap;
import java.util.Map;

class FeatureValidatorFactory {

    private static final FeatureValidatorFactory instance = new FeatureValidatorFactory();
    private final Map<String, FeatureValidator> validators = new HashMap<>();

    {
        validators.put(SearchCriteria.General.NAME.name(), new ApplianceNameValidator());
        validators.put(SearchCriteria.General.PRICE.name(), new DoubleValidator());
        validators.put(SearchCriteria.PriceFilter.MORE_THAN_CURRENT_PRICE.name(), new DoubleValidator());
        validators.put(SearchCriteria.PriceFilter.LESS_THAN_CURRENT_PRICE.name(), new DoubleValidator());
        validators.put(SearchCriteria.PriceFilter.EQUAL_CURRENT_PRICE.name(), new DoubleValidator());

        validators.put(SearchCriteria.Laptop.BATTERY_CAPACITY.name(), new DoubleValidator());
        validators.put(SearchCriteria.Laptop.OS.name(), new OSValidator());
        validators.put(SearchCriteria.Laptop.MEMORY_ROM.name(), new DoubleValidator());
        validators.put(SearchCriteria.Laptop.CPU.name(), new CPUValidator());
        validators.put(SearchCriteria.Laptop.DISPLAY_INCHES.name(), new DoubleValidator());

        validators.put(SearchCriteria.Teapot.POWER.name(), new DoubleValidator());
        validators.put(SearchCriteria.Teapot.WEIGHT.name(), new DoubleValidator());
        validators.put(SearchCriteria.Teapot.BULK.name(), new DoubleValidator());
        validators.put(SearchCriteria.Teapot.COLOR.name(), new ColorValidator());

        validators.put(SearchCriteria.Fridge.COLOR.name(), new ColorValidator());
        validators.put(SearchCriteria.Fridge.COMPANY.name(), new CompanyValidator());
    }

    private FeatureValidatorFactory() { }

    static FeatureValidatorFactory getInstance() {
        return instance;
    }

    FeatureValidator getValidator(String criteriaName) {
        if (validators.containsKey(criteriaName)) {
            return validators.get(criteriaName);
        }
        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
    }

}
