import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BriqueTest {
    @Test
    public void makemove(){
        Brique brique = new Brique();

        brique.makeMove(new Posizione(5,5), Player.PLAYER1);

        Player actualPlayer = brique.checkSquarePlayer(new Posizione(5,5));
        Player expectedPlayer = Player.PLAYER1;

        assertEquals(expectedPlayer,actualPlayer);
    }
}
