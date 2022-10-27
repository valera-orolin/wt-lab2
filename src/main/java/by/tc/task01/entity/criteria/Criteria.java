package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

import static by.tc.task01.entity.criteria.ApplianceNameConstants.ALL;

public class Criteria {

	private final Map<String, Object> featureMap = new HashMap<>();
	final private String groupSearchName;

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public Criteria() {
		this.groupSearchName = ALL;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public Map<String, Object> getFeatureMap() {
		return featureMap;
	}

	public void add(String searchFeature, Object value) {
		featureMap.put(searchFeature, value);
	}

}
