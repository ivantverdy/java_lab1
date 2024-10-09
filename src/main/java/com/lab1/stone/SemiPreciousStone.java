package com.lab1.stone;

public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String name, double carat, double purity) {
        super(name, carat, purity);
        this.value = calculateValue();
    }

    @Override
    public double calculateValue() {
        return getCarat() * getPurity() * 1000;
    }

    @Override
    public String toString() {
        return "Stone: name = " + getName() + ", carat = " + getCarat() + ", purity = " + getPurity() + ", value = " + calculateValue();
    }
}
