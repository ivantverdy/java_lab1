package com.lab1.stone;

public class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String name, double carat, double cost, double purity) {
        super(name, carat, cost, purity);
    }

    @Override
    public double calculateValue() {
        return getCarat() * getCost() * getPurity();
    }
}
