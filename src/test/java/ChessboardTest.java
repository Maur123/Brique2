import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChessboardTest {


    @ParameterizedTest
    @CsvSource({
            "7,5" , "2,1" , "14,14"
    })
    public void checkSquareState(int row, int column){
        Chessboard board = new Chessboard();

        var actualSquareValue = board.checkSquarePlayer(new Posizione(row,column));

        assertEquals(null,actualSquareValue);
    }

    @ParameterizedTest
    @CsvSource({
            "7,5,PLAYER1" , "2,1,PLAYER2" , "14,14,PLAYER2"
    })
    public void updateSquareState(int row, int column, Player player){
        Chessboard board = new Chessboard();

        board.updateSquarePlayer(new Posizione(row,column), player);

        Player actualPlayer = board.checkSquarePlayer(new Posizione(row,column));
        Player expectedPlayer = player;

        assertEquals(expectedPlayer,actualPlayer);
    }

    @ParameterizedTest
    @CsvSource({
            "7,4,WHITE" , "2,11,WHITE" , "14,14,BLACK"
    })
    public void checkSquareColor(int row, int column, ColorSquare color){
        Chessboard board = new Chessboard();


        ColorSquare actualSquareColor = board.checkSquareColor(new Posizione(row,column));

        ColorSquare expectedColorSquare = color;

        assertEquals(expectedColorSquare,actualSquareColor);

    }

    @ParameterizedTest
    @CsvSource({
            "7,4,true" , "2,11,true" , "14,25,false" , "-6,4,false"
    })
    public void checkPosition(int row, int column, boolean expect){
        Chessboard board = new Chessboard();


        Posizione position = new Posizione(row,column);

        boolean checkposition = board.isValidPosition(position);

        assertEquals(expect,checkposition);
    }
}
