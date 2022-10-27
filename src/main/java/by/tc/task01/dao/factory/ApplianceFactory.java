package by.tc.task01.dao.factory;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceNameConstants;
import org.w3c.dom.NodeList;

public abstract class ApplianceFactory {

    public abstract Appliance createAppliance(NodeList nodeList);

    public static ApplianceFactory getApplianceFactory(String applianceName) {
        switch (applianceName) {
            case ApplianceNameConstants.LAPTOP:
                return new LaptopFactory();
            case ApplianceNameConstants.TEAPOT:
                return new TeapotFactory();
            case ApplianceNameConstants.FRIDGE:
                return new FridgeFactory();
            default:
                throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_FACTORY_EXCEPTION_MSG);
        }
    }

}
