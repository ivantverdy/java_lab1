package com.lab1.necklace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.lab1.stone.Stone;

public class Necklace {
    private List<Stone> stones;

    public Necklace() {
        this.stones = new ArrayList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public double getWeight() {
        return stones.stream().mapToDouble(Stone::getCarat).sum(); // map to double takes stone object and applies getCarat() to each one
    }

    public double getCost() {
        return stones.stream().mapToDouble(Stone::getCost).sum();
    }

    public void sortByValue() {
        stones.sort(Comparator.comparingDouble(Stone::calculateValue));
    }

    public List<Stone> getStonesInPurityRange(double min, double max) {
        List<Stone> stonesInRange = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getPurity() >= min && stone.getPurity() <= max) {
                stonesInRange.add(stone);
            }
        }
        return stonesInRange;
    }
}
