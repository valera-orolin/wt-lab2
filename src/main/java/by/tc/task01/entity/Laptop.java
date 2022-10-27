package by.tc.task01.entity;

import by.tc.task01.entity.criteria.ApplianceNameConstants;
import by.tc.task01.entity.criteria.CriteriaConstants;
import by.tc.task01.entity.enums.CPU;
import by.tc.task01.entity.enums.OS;

import java.util.Objects;

public class Laptop extends Appliance{

    private double batteryCapacity;
    private double memoryRom;
    private double displayInches;
    private OS os;
    private CPU cpu;

    public Laptop() { }

    public Laptop(double price, double batteryCapacity, OS os, double memoryRom, CPU cpu, double displayInches) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    @Override
    public boolean isMatchesCriteria(String criteriaName, Object value) {
        switch (criteriaName) {
            case CriteriaConstants.PRICE:
            case CriteriaConstants.MORE_THAN_CURRENT_PRICE:
            case CriteriaConstants.LESS_THAN_CURRENT_PRICE:
            case CriteriaConstants.EQUAL_CURRENT_PRICE:
                return super.isMatchesCriteria(criteriaName, value);
            case CriteriaConstants.APPLIANCE_NAME:
                return ApplianceNameConstants.LAPTOP.equals(value);
            case CriteriaConstants.BATTERY_CAPACITY:
                return (double) value == batteryCapacity;
            case CriteriaConstants.OS:
                return os.equals(OS.valueOf((String) value));
            case CriteriaConstants.MEMORY_ROM:
                return (double) value == memoryRom;
            case CriteriaConstants.CPU:
                return cpu.equals(CPU.valueOf((String) value));
            case CriteriaConstants.DISPLAY_INCHES:
                return (double) value == displayInches;
            default:
                return false;
        }
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public OS getOs() {
        return os;
    }

    public double getMemoryRom() {
        return memoryRom;
    }

    public CPU getCpu() {
        return cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return batteryCapacity == laptop.batteryCapacity
                && memoryRom == laptop.memoryRom
                && Double.compare(laptop.displayInches, displayInches) == 0
                && os == laptop.os
                && cpu == laptop.cpu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, os, memoryRom, cpu, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop [" +
                "price - " + super.getPrice() +
                " | batteryCapacity - " + batteryCapacity +
                " | os - " + os +
                " | memoryRom - " + memoryRom +
                " | cpu - " + cpu +
                " | displayInches - " + displayInches +
                ']';
    }
}
