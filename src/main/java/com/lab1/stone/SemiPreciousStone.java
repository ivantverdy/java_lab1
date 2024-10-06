package com.lab1.stone;

public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String name, double carat, double purity) {
        super(name, carat, purity);
    }

    @Override
    public double calculateValue() {
        return getCarat() * getPurity();
    }
}
