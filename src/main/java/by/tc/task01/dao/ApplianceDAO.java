package by.tc.task01.dao;

import by.tc.task01.Exceptions.ResourceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {

	List<Appliance> find(Criteria feature) throws ResourceException;

}
