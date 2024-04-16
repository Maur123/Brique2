import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
