package by.tc.task01.entity;

import by.tc.task01.entity.criteria.CriteriaConstants;
import by.tc.task01.entity.enums.Color;

import java.util.Objects;

public class Appliance {

    protected Color color;
    private double price;

    public Appliance() {
    }

    public Appliance(double price) {
        this.price = price;
    }

    public boolean isMatchesCriteria(String criteriaName, Object value) {
        switch (criteriaName) {
            case CriteriaConstants.MORE_THAN_CURRENT_PRICE:
                return price > (double) value;
            case CriteriaConstants.LESS_THAN_CURRENT_PRICE:
                return price < (double) value;
            case CriteriaConstants.PRICE:
            case CriteriaConstants.EQUAL_CURRENT_PRICE:
                return price == (double) value;
            default:
                return false;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return Double.compare(appliance.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Appliance [" +
                "price - " + price +
                ']';
    }
}
