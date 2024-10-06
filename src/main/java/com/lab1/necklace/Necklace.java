package com.lab1.necklace;

import java.util.ArrayList;
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
}
