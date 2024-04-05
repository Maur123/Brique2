import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ChessboardTest {


    @ParameterizedTest
    @CsvSource({
            "7,5", "2,1", "14,14"
    })
    public void TestCheckSquareState(int row, int column) {
        Chessboard board = new Chessboard(15);

        var actualSquareValue = board.checkSquarePlayer(new Position(row, column));

        assertNull(actualSquareValue);
    }

    @ParameterizedTest
    @CsvSource({
            "7,5,PLAYER1", "2,1,PLAYER2", "14,14,PLAYER2"
    })
    public void TestUpdateSquareState(int row, int column, Player player) {
        Chessboard board = new Chessboard(15);

        board.updateSquarePlayer(new Position(row, column), player);

        Player actualPlayer = board.checkSquarePlayer(new Position(row, column));

        assertEquals(player, actualPlayer);
    }

    @ParameterizedTest
    @CsvSource({
            "7,4,WHITE", "2,11,WHITE", "14,14,BLACK", "2,8,BLACK"
    })
    public void TestCheckSquareColor(int row, int column, ColorSquare color) {
        Chessboard board = new Chessboard(15);


        ColorSquare actualSquareColor = board.checkSquareColor(new Position(row, column));

        assertEquals(color, actualSquareColor);

    }

    @ParameterizedTest
    @CsvSource({
            "7,4,true", "2,11,true", "14,25,false", "-6,4,false"
    })
    public void TestCheckPosition(int row, int column, boolean expect) {
        Chessboard board = new Chessboard(15);

        Position position = new Position(row, column);

        boolean checkPosition = board.isValidPosition(position);

        assertEquals(expect, checkPosition);
    }

    @ParameterizedTest
    @CsvSource({
            "7,5,PLAYER1,PLAYER1,true", "2,1,PLAYER2,PLAYER1,false"
    })
    public void TestIsSquareOfPlayer(int row, int column, Player player1, Player player2, boolean expected) {
        Chessboard board = new Chessboard(15);

        board.updateSquarePlayer(new Position(row, column), player1);

        boolean checkPlayerSquare = board.isSquareOfPlayer(new Position(row, column), player2);

        assertEquals(expected, checkPlayerSquare);
    }

    @ParameterizedTest
    @CsvSource({
            "7,5,PLAYER1,7,5,false", "3,3,PLAYER1,3,3,false", "7,5,PLAYER1,6,5,true", "2,1,PLAYER2,4,1,true"
    })
    public void TestAvailablePosition(int row1, int column1, Player player, int row2, int column2, boolean expected) {
        Chessboard board = new Chessboard(15);

        board.updateSquarePlayer(new Position(row1, column1), player);

        boolean checkSquareAvailable = board.isSquareAvailable(new Position(row2, column2));

        assertEquals(expected, checkSquareAvailable);
    }

    @ParameterizedTest
    @CsvSource({
            "7,5,PLAYER1", "2,1,PLAYER2"
    })
    public void TestCleanChessboard(int row, int column, Player player) {
        Chessboard board = new Chessboard(15);

        board.updateSquarePlayer(new Position(row, column), player);

        board.cleanChessboard();

        boolean expected = true;

        boolean checkSquareAvailable = board.isSquareAvailable(new Position(row, column));

        assertEquals(expected, checkSquareAvailable);
    }

}
