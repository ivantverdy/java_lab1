package lab1.stone;

import com.lab1.stone.PreciousStone;
import com.lab1.stone.SemiPreciousStone;
import com.lab1.stone.Stone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class StoneTest {

    @Test
    public void PreciousStoneTest() {
        PreciousStone stone = new PreciousStone("Diamond", 2.5, 0.93, 2);

        assertEquals("Diamond", stone.getName());
        assertEquals(2.5, stone.getCarat());
        assertEquals(0.93, stone.getPurity());
        assertEquals(2, stone.getRarity());
        assertEquals(10000 * 2.5 * 0.93 * 2, stone.calculateValue());
    }

    @Test
    public void SemiPreciousStoneTest() {
        SemiPreciousStone stone = new SemiPreciousStone("Amethyst", 1.0, 0.6);

        assertEquals("Amethyst", stone.getName());
        assertEquals(1.0, stone.getCarat());
        assertEquals(0.6, stone.getPurity());
        assertEquals(1000 * 1.0 * 0.6, stone.calculateValue());
    }

}
