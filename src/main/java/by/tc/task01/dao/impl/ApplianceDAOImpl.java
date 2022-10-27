package by.tc.task01.dao.impl;

import by.tc.task01.Exceptions.ResourceException;
import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.factory.ApplianceFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceNameConstants;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public List<Appliance> find(Criteria criteria) throws ResourceException {
		List<Appliance> appliances = new ArrayList<>();
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document
					= documentBuilder.parse(Objects.requireNonNull(getClass().getClassLoader().getResource("Appliances.xml")).getFile());
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					ApplianceFactory applianceFactory = ApplianceFactory.getApplianceFactory(node.getNodeName());

					if (criteria.getGroupSearchName().equals(node.getNodeName()) || criteria.getGroupSearchName().equals(ApplianceNameConstants.ALL)) {
						Appliance appliance = applianceFactory.createAppliance(node.getChildNodes());

						if (criteria.getFeatureMap()
								.entrySet()
								.stream()
								.allMatch(entry -> appliance.isMatchesCriteria(entry.getKey(), entry.getValue()))) {
							appliances.add(appliance);
						}
					}
				}
			}

		} catch (ParserConfigurationException | IOException | SAXException e) {
			throw new ResourceException(e);
		}
		return appliances;
	}

}