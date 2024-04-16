import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveEffectsManagerTest {
    MoveEffectsManager manager;

    @Nested
    class TestUpdate {

        @ParameterizedTest
        @MethodSource("provideChessboardForCheckCorrectRules")
        public void itShouldUpdateSquare(Chessboard chessboard, Player player, Position movePosition, Position positionToCheck) {
            manager = new MoveEffectsManager(chessboard);

            manager.update(movePosition, player);

            boolean isSquareOfPlayer = chessboard.isSquareOfPlayer(positionToCheck, player);

            assertTrue(isSquareOfPlayer);
        }

        @ParameterizedTest
        @MethodSource("provideChessboardForCheckIfThereIsWrongRules")
        public void itShouldNotUpdateSquare(Chessboard chessboard, Player player, Position movePosition, Position positionToCheck) {
            manager = new MoveEffectsManager(chessboard);

            manager.update(movePosition, player);

            boolean isSquareOfPlayer = chessboard.isSquareOfPlayer(positionToCheck, player);

            assertFalse(isSquareOfPlayer);

        }

        private static Stream<Arguments> provideChessboardForCheckCorrectRules() {
            return Stream.of(
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, new Position(0, 1), new Position(0, 2)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, new Position(0, 1), new Position(0, 0)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(4, 3)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(4, 5)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(5, 4)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, new Position(5, 5), new Position(5, 4)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, new Position(5, 5), new Position(5, 6)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, new Position(5, 5), new Position(6, 5)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, new Position(13, 12), new Position(12, 12)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, new Position(13, 12), new Position(13, 11))
            );
        }

        private static Stream<Arguments> provideChessboardForCheckIfThereIsWrongRules() {
            return Stream.of(
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, new Position(0, 1), new Position(1, 1)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer1(), Player.PLAYER1, new Position(0, 1), new Position(0, 3)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(3, 4)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(6, 3)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer2(), Player.PLAYER2, new Position(4, 4), new Position(6, 5)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, new Position(5, 5), new Position(4, 5)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnBlackOfPlayer1(), Player.PLAYER1, new Position(5, 5), new Position(7, 4)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, new Position(13, 12), new Position(13, 13)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, new Position(13, 12), new Position(14, 13)),
                    Arguments.of(ChessboardTestDataFactory.createChessboardForManageMoveOnWhiteOfPlayer2(), Player.PLAYER2, new Position(13, 12), new Position(14, 12))
            );
        }

    }


}
