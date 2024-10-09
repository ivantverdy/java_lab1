package lab1.necklace;

import com.lab1.necklace.Necklace;
import com.lab1.stone.PreciousStone;
import com.lab1.stone.SemiPreciousStone;
import com.lab1.stone.Stone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class NecklaceTest {

    private Necklace necklace;

    @BeforeEach
    void setUp() {
        necklace = new Necklace();
        necklace.addStone(new PreciousStone("Diamond", 2.5, 0.93, 2));
        necklace.addStone(new SemiPreciousStone("Amethyst", 1.0, 0.6));
        necklace.addStone(new PreciousStone("Ruby", 3.0, 0.82, 1.6));
    }

    @Test
    void testAddStone() {
        assertEquals(3, necklace.getStones().size(), "Necklace should contain 3 stones.");
    }

    @Test
    void testGetWeight() {
        double totalWeight = necklace.getWeight();
        assertEquals(6.5, totalWeight, "Total weight should be 6.5 carats.");
    }

    @Test
    void testGetCost() {
        double totalCost = necklace.getCost();
        assertEquals(86460.0, totalCost, "Total cost should be 86460.0 USD.");
    }

    @Test
    void testSortByValue() {
        necklace.sortByValue();
        List<Stone> sortedStones = necklace.getStones();
        assertEquals("Amethyst", sortedStones.get(0).getName());
        assertEquals("Ruby", sortedStones.get(1).getName());
        assertEquals("Diamond", sortedStones.get(2).getName());
    }

    @Test
    void testGetStonesInPurityRange() {
        List<Stone> stonesInRange = necklace.getStonesInPurityRange(0.5, 0.9);
        assertEquals(2, stonesInRange.size());
        assertEquals("Amethyst", stonesInRange.get(0).getName());
        assertEquals("Ruby", stonesInRange.get(1).getName());
    }
}