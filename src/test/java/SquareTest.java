import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void testIsNotFree(){
        Square square = new Square(ColorSquare.BLACK);

        square.occupy(Player.PLAYER1);

        boolean actualState = square.isFree();
        boolean expectedState = false;

        assertEquals(expectedState, actualState);
    }

    @Test
    public void testIsFree(){
        Square square = new Square(ColorSquare.BLACK);

        boolean actualState = square.isFree();
        boolean expectedState = true;

        assertEquals(expectedState, actualState);
    }
}
