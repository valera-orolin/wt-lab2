package by.tc.task01.service.impl;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.Exceptions.ResourceException;
import by.tc.task01.Exceptions.ServiceException;
import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.List;


public class ApplianceServiceImpl implements ApplianceService {
	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.isCriteriaValid(criteria)) {
			throw new ServiceException(ExceptionMessageConstant.INVALID_CRITERIA_EXCEPTION_MSG);
		}

		List<Appliance> appliances;
		try {
			DAOFactory factory = DAOFactory.getInstance();
			ApplianceDAO applianceDAO = factory.getApplianceDAO();
			appliances = applianceDAO.find(criteria);
		} catch (ResourceException e) {
			throw new ServiceException(e);
		}
		return appliances;
	}
}
