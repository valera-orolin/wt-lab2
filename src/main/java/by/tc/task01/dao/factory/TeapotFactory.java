package by.tc.task01.dao.factory;

import by.tc.task01.Exceptions.ExceptionMessageConstant;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Teapot;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.enums.Color;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TeapotFactory extends ApplianceFactory {

    int price;
    double power;
    double weight;
    double bulk;
    Color color;

    @Override
    public Appliance createAppliance(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String value = nodeList.item(i).getTextContent();
                SearchCriteria.Teapot teapotSearchCriteria = SearchCriteria.Teapot.valueOf(nodeList.item(i).getNodeName().toUpperCase());
                switch (teapotSearchCriteria) {
                    case PRICE:
                        price = Integer.parseInt(value);
                        break;
                    case POWER:
                        power = Double.parseDouble(value);
                        break;
                    case WEIGHT:
                        weight = Double.parseDouble(value);
                        break;
                    case BULK:
                        bulk = Double.parseDouble(value);
                        break;
                    case COLOR:
                        color = Color.valueOf(value);
                        break;
                    default:
                        throw new IllegalArgumentException(ExceptionMessageConstant.ILLEGAL_ARGUMENT_CRITERIA_EXCEPTION_MSG);
                }

            }
        }
        return new Teapot(price, power, weight, bulk, color);
    }

}
