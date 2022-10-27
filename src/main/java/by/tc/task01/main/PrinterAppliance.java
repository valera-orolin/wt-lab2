package by.tc.task01.main;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.entity.Appliance;

import java.util.List;

class PrinterAppliance {

	static void print(List<Appliance> appliances) {
		if (appliances == null) {
			System.out.println(ExceptionMessageConstant.APPLIANCES_LIST_NULL_EXCEPTION_MSG);
		} else if (appliances.isEmpty()) {
			System.out.println(ExceptionMessageConstant.APPLIANCES_LIST_EMPTY_EXCEPTION_MSG);
		} else {
			for (Appliance appliance : appliances) {
				System.out.println(appliance);
			}
		}
	}

}
