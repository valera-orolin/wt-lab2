package by.tc.task01.main;

import by.tc.task01.Exceptions.ResourceException;
import by.tc.task01.Exceptions.ServiceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceNameConstants;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.List;

public class Main {

	public static void main(String[] args) throws ResourceException, ServiceException {

		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		System.out.println("1");
		Criteria criteriaFridge = new Criteria(ApplianceNameConstants.FRIDGE);
		criteriaFridge.add(SearchCriteria.Fridge.COLOR.name(), "WHITE");
		criteriaFridge.add(SearchCriteria.Fridge.COMPANY.name(), "SAMSUNG");
		appliances = service.find(criteriaFridge);
		PrinterAppliance.print(appliances);
		System.out.println();


		System.out.println("2");
		Criteria criteriaLaptop = new Criteria(ApplianceNameConstants.LAPTOP);
		criteriaLaptop.add(SearchCriteria.PriceFilter.LESS_THAN_CURRENT_PRICE.name(), 10000.0);
		appliances = service.find(criteriaLaptop);
		PrinterAppliance.print(appliances);
		System.out.println();


		System.out.println("3");
		Criteria criteriaTeapot = new Criteria(ApplianceNameConstants.TEAPOT);
		criteriaTeapot.add(SearchCriteria.Teapot.POWER.name(), 1000.0);
		criteriaTeapot.add(SearchCriteria.Teapot.BULK.name(), 1.0);
		appliances = service.find(criteriaTeapot);
		PrinterAppliance.print(appliances);
		System.out.println();


		System.out.println("4");
		Criteria criteria = new Criteria();
		criteria.add(SearchCriteria.PriceFilter.LESS_THAN_CURRENT_PRICE.name(), 200.0);
		appliances = service.find(criteria);
		PrinterAppliance.print(appliances);
		System.out.println();

	}

}
