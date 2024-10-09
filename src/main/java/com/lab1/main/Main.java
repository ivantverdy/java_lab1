package com.lab1.main;

import com.lab1.necklace.Necklace;
import com.lab1.stone.SemiPreciousStone;
import com.lab1.stone.PreciousStone;
import com.lab1.stone.Stone;

public class Main {
    public static void main(String[] args) {
        Necklace necklace = new Necklace();

        necklace.addStone(new PreciousStone("Diamond", 2.5, 0.93, 2));
        necklace.addStone(new SemiPreciousStone("Amethyst", 1.0, 0.6));
        necklace.addStone(new PreciousStone("Ruby", 3.0, 0.82, 1.6));

        System.out.println("Total weight: " + necklace.getWeight() + " carats");

        System.out.println("Total cost: " + necklace.getCost() + " usd");

        necklace.sortByValue();
        System.out.println("Sorted by value stones: ");
        for (Stone stone : necklace.getStones()) {
            System.out.println(stone);
        }

        double minPurity = 0.5;
        double maxPurity = 0.9;
        System.out.println("Stones with purity between " + minPurity + " and " + maxPurity + ":");
        for (Stone stone : necklace.getStonesInPurityRange(minPurity, maxPurity)) {
            System.out.println(stone);
        }

        necklace.saveToDb();

        Necklace dbStones = new Necklace();
        dbStones.getFromDb();
        System.out.println("Stones from db: ");
        for (Stone stone : dbStones.getFromDb()) {
            System.out.println(stone);
        }
    }
}
