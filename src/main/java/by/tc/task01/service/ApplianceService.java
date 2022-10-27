package by.tc.task01.service;

import by.tc.task01.Exceptions.ResourceException;
import by.tc.task01.Exceptions.ServiceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {

	List<Appliance> find(Criteria feature) throws ResourceException, ServiceException;
	
}
