import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BriqueTest {
    Brique brique;
    Chessboard chessboard;

    @BeforeEach
    public void setup() {
        chessboard = new Chessboard(15);
        brique = new Brique(chessboard);
    }

    @Nested
    class TestMakeMove {

        @ParameterizedTest
        @CsvSource({
                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER2", "6,4,PLAYER2"
        })
        public void itShouldUpdateTheSquare(int row, int column, Player player) {
            Position pos = new Position(row, column);

            brique.makeMove(pos, player);
            Player updatedPlayer = chessboard.checkSquarePlayer(pos);

            assertNotEquals(null, updatedPlayer);
        }

        @ParameterizedTest
        @CsvSource({
                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER2", "6,4,PLAYER2"
        })
        public void itShouldUpdateTheSquare2(int row, int column, Player player) {
            Position pos = new Position(row, column);

            brique.makeMove(pos, player);
            Player updatedPlayer = chessboard.checkSquarePlayer(pos);

            assertEquals(player, updatedPlayer);
        }
    }

    @Nested
    class TestManageMoveEffects {
        @ParameterizedTest
        @MethodSource("provideChessboardForCheckCorrectRules")
        public void itShouldUpdateSquare(Chessboard chessboard2, Player player, int moveRow, int moveColumn, int rowToCheck, int columnToCheck) {

            Position pos = new Position(moveRow, moveColumn);
            Brique brique2 = new Brique(chessboard2);
            brique2.manageMoveEffects(pos, player);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Position(rowToCheck, columnToCheck), player);

            boolean expected = true;

            assertEquals(expected, check);

        }

        @ParameterizedTest
        @MethodSource("provideChessboardForCheckIfThereIsWrongRules")
        public void itShouldNotUpdateSquare(Chessboard chessboard2, Player player, int moveRow, int moveColumn, int rowToCheck, int columnToCheck) {

            Position pos = new Position(moveRow, moveColumn);
            Brique brique2 = new Brique(chessboard2);
            brique2.manageMoveEffects(pos, player);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Position(rowToCheck, columnToCheck), player);

            boolean expected = false;

            assertEquals(expected, check);

        }

        private static Stream<Arguments> provideChessboardForCheckCorrectRules() {
            return Stream.of(
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, 0, 1, 0, 2),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, 0, 1, 0, 0),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 4, 3),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 4, 5),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 5, 4),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, 5, 5, 5, 4),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, 5, 5, 5, 6),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, 5, 5, 6, 5),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, 13, 12, 12, 12),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, 13, 12, 13, 11)
            );
        }

        private static Stream<Arguments> provideChessboardForCheckIfThereIsWrongRules() {
            return Stream.of(
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, 0, 1, 1, 1),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, 0, 1, 0, 3),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 3, 4),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 6, 3),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, 4, 4, 6, 5),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, 5, 5, 4, 5),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, 5, 5, 7, 4),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, 13, 12, 13, 13),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, 13, 12, 14, 13),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, 13, 12, 14, 12)
            );
        }

    }


}
