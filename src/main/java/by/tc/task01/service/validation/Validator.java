package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

public class Validator {

	public static boolean isCriteriaValid(Criteria feature) {
		if (feature == null) {
			return false;
		}
		return feature.getFeatureMap().entrySet().stream().allMatch(
				entry -> FeatureValidatorFactory.getInstance()
						.getValidator(entry.getKey())
						.isCriteriaValid(entry.getValue()));
	}
}