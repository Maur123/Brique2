import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VictoryCheckerTest {


    @ParameterizedTest
    @MethodSource("provideChessboardAndWinningPlayer")
    public void testHasPlayerWon(Chessboard chessboard, Player player) {
        VictoryChecker victoryChecker = new VictoryChecker(player, chessboard);

        boolean actualResult = victoryChecker.hasPlayerWon();
        boolean expectedResult = true;

        assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @MethodSource("provideChessboardAndNotWinningPlayer")
    public void testHasPlayerNotWon(Chessboard chessboard, Player player) {
        VictoryChecker victoryChecker = new VictoryChecker(player, chessboard);

        boolean actualResult = victoryChecker.hasPlayerWon();
        boolean expectedResult = false;

        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideChessboardAndWinningPlayer() {
        return Stream.of(
                Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard(), Player.PLAYER1),
                Arguments.of(ChessboardTestDataFactory.createPlayer2WinningChessboard(), Player.PLAYER2)
        );
    }

    private static Stream<Arguments> provideChessboardAndNotWinningPlayer() {
        return Stream.of(
                Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard(), Player.PLAYER2),
                Arguments.of(ChessboardTestDataFactory.createPlayer2WinningChessboard(), Player.PLAYER1)
        );
    }

}
