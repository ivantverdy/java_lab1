package com.lab1.stone;

public abstract class Stone {
    private String name;
    private double carat;
    private double cost;
    private double purity;

    public Stone(String name, double carat, double cost, double purity) {
        this.name = name;
        this.carat = carat;
        this.cost = cost;
        this.purity = purity;
    }

    public String getName() {
        return name;
    }

    public double getCarat() {
        return carat;
    }

    public double getCost() {
        return cost;
    }

    public double getPurity() {
        return purity;
    }

    public abstract double calculateValue();

    @Override
    public String toString() {
        return "Stone: name=" + name + ", carat=" + carat + ", cost=" + cost + ", purity=" + purity + ".";
    }
}
