package fr.yanport.asspirateur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest 
{
    @Test
    public void test1 () throws GameConfigException {
        Game game = new Game(10, 10, 5, 5, "N", "DADADADAA");
        assertEquals(game.getAsspirateur().getPositionX(), 5);
        assertEquals(game.getAsspirateur().getPositionY(), 6);
        assertEquals(game.getAsspirateur().getOrientation(), Orientation.N);

    }
}
