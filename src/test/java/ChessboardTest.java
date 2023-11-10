import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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


        ColorSquare actualSquareColor = board.checkSquareColor(new Posizione(8,5));

        ColorSquare expectedColorSquare = ColorSquare.WHITE;

        assertEquals(expectedColorSquare,actualSquareColor);

    }

    @Test
    public void checkImpossiblePosition(){
        Chessboard board = new Chessboard();


        Posizione position = new Posizione(-4,5);

        boolean checkposition = board.isValidPosition(position);

        assertNotEquals(true,checkposition);
    }
    @Test
    public void checkImpossiblePosition2(){
        Chessboard board = new Chessboard();


        Posizione position = new Posizione(14,25);

        boolean checkposition = board.isValidPosition(position);

        assertNotEquals(true,checkposition);
    }
    @Test
    public void checkPossiblePosition(){
        Chessboard board = new Chessboard();


        Posizione position = new Posizione(4,5);

        boolean checkposition = board.isValidPosition(position);

        assertEquals(true,checkposition);
    }
}
