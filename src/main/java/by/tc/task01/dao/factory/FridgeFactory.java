package by.tc.task01.dao.factory;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Fridge;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.enums.Color;
import by.tc.task01.entity.enums.Company;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FridgeFactory extends ApplianceFactory {

    int price;
    Color color;
    Company company;

    @Override
    public Appliance createAppliance(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String value = nodeList.item(i).getTextContent();
                SearchCriteria.Fridge tabletPCSearchCriteria = SearchCriteria.Fridge.valueOf(nodeList.item(i).getNodeName().toUpperCase());
                switch (tabletPCSearchCriteria) {
                    case PRICE:
                        price = Integer.parseInt(value);
                        break;
                    case COLOR:
                        color = Color.valueOf(value);
                        break;
                    case COMPANY:
                        company = Company.valueOf(value);
                        break;
                    default:
                        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
                }
            }
        }
        return new Fridge(price, color, company);
    }

}
