package com.lab1.stone;

public class PreciousStone extends Stone {
    private double rarity;

    public PreciousStone(String name, double carat, double purity, double rarity) {
        super(name, carat, purity);
        this.rarity = rarity;
    }

    public double getRarity() {
        return rarity;
    }

    @Override
    public double calculateValue() {
        return getCarat() * getPurity() * getRarity();
    }
}
