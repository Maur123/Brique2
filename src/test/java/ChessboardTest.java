import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessboardTest {

    @Test
    public void checkSquareState(){
        Chessboard board = new Chessboard();


        var actualSquareValue = board.checkSquarePlayer(new Posizione(7,5));

        assertEquals(null,actualSquareValue);

    }
    @Test
    public void updateSquareState(){
        Chessboard board = new Chessboard();

        board.updateSquarePlayer(new Posizione(7,5), Player.PLAYER1);

        Player actualPlayer = board.checkSquarePlayer(new Posizione(7,5));
        Player expectedPlayer = Player.PLAYER1;

        assertEquals(expectedPlayer,actualPlayer);
    }
    @Test
    public void checkSquareColor(){
        Chessboard board = new Chessboard();


        Color actualSquareColor = board.checkSquareColor(new Posizione(8,5));

        Color expectedColor = Color.WHITE;

        assertEquals(expectedColor,actualSquareColor);

    }
}
