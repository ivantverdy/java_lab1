package com.lab1.stone;

public abstract class Stone {
    private String name;
    private double carat;
    private double purity;
    protected double value;

    public Stone(String name, double carat, double purity) {
        this.name = name;
        this.carat = carat;
        this.purity = purity;
        this.value = calculateValue();
    }

    public String getName() {
        return name;
    }

    public double getCarat() {
        return carat;
    }

    public double getPurity() {
        return purity;
    }

    public double getValue() {
        return value;
    }

    public abstract double calculateValue();

}
