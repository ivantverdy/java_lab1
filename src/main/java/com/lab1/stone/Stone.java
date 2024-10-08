package com.lab1.stone;

public abstract class Stone {
    private String name;
    private double carat;
    private double purity;

    public Stone(String name, double carat, double purity) {
        this.name = name;
        this.carat = carat;
        this.purity = purity;
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

    public abstract double calculateValue();

}
