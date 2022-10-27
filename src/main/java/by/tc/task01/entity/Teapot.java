package by.tc.task01.entity;

import by.tc.task01.entity.criteria.ApplianceNameConstants;
import by.tc.task01.entity.criteria.CriteriaConstants;
import by.tc.task01.entity.enums.Color;

import java.util.Objects;

public class Teapot extends Appliance {

    private double power;
    private double weight;
    private double bulk;
    private Color color;

    public Teapot() { }

    public Teapot(double price,
                  double power,
                  double weight,
                  double bulk,
                  Color color) {
        super(price);
        this.power = power;
        this.weight = weight;
        this.bulk = bulk;
        this.color = color;

    }

    @Override
    public boolean isMatchesCriteria(String featureName, Object value) {
        switch (featureName) {
            case CriteriaConstants.PRICE:
            case CriteriaConstants.MORE_THAN_CURRENT_PRICE:
            case CriteriaConstants.LESS_THAN_CURRENT_PRICE:
            case CriteriaConstants.EQUAL_CURRENT_PRICE:
                return super.isMatchesCriteria(featureName, value);
            case CriteriaConstants.APPLIANCE_NAME:
                return ApplianceNameConstants.TEAPOT.equals(value);
            case CriteriaConstants.POWER:
                return (double) value == power;
            case CriteriaConstants.WEIGHT:
                return (double) value == weight;
            case CriteriaConstants.BULK:
                return (double) value == bulk;
            case CriteriaConstants.COLOR:
                return color.equals(Color.valueOf((String) value));
            default:
                return false;
        }
    }

    public double getPower() {
        return power;
    }

    public double getWidth() {
        return weight;
    }

    public double getBulk() {
        return bulk;
    }

    public Color getColor() {
        return color;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teapot teapot = (Teapot) o;
        return Double.compare(teapot.power, power) == 0 && Double.compare(teapot.bulk, bulk) == 0 &&  Double.compare(teapot.weight, weight) == 0 && color == teapot.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power, weight, bulk);
    }

    @Override
    public String toString() {
        return "Teapot [" +
                "price - " + super.getPrice() +
                " | power - " + power +
                " | weight - " + weight +
                " | bulk - " + bulk +
                " | color - " + color +
                ']';
    }
}
