import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//@RunWith(MockitoJUnitRunner.class)
public class BriqueTest3withCSVsources {
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
            Posizione pos = new Posizione(row, column);

            brique.makeMove(pos, player);
            Player updatedPlayer = chessboard.checkSquarePlayer(pos);

            assertNotEquals(null, updatedPlayer);
        }

        @ParameterizedTest
        @CsvSource({
                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER2", "6,4,PLAYER2"
        })
        public void itShouldUpdateTheSquare2(int row, int column, Player player) {
            Posizione pos = new Posizione(row, column);

            brique.makeMove(pos, player);
            Player updatedPlayer = chessboard.checkSquarePlayer(pos);

            assertEquals(player, updatedPlayer);
        }
    }

    @Nested
    class TestManageMoveEffects_UpdateSquareOnWhite2 {

        @ParameterizedTest
        @CsvSource({
                "4,4,PLAYER2,true", "5,4,PLAYER2,true", "4,3,PLAYER2,true", "4,5,PLAYER2,true", "3,4,PLAYER2,false"
        })
        public void itShouldUpdateTheBlackSquareForPlayer2(int row, int col, boolean expected) {

            Posizione pos = new Posizione(4, 4);

            String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
            Chessboard chessboard2 = new Chessboard(15);

            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

            Brique brique2 = new Brique(chessboard2);
            brique2.manageMoveEffects(pos, Player.PLAYER2);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Posizione(row, col), Player.PLAYER2);

            assertEquals(expected, check);

        }
        @ParameterizedTest
        @CsvSource({
                "0,2,true", "1,1,false"
        })
        public void itShouldUpdateTheWhiteSquareForPlayer1(int row, int col, boolean expected) {

            Posizione pos = new Posizione(0, 1);

            String filePath = "src/test/resources/MatrixForPlayer1White.txt";
            Chessboard chessboard2 = new Chessboard(15);

            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

            Brique brique2 = new Brique(chessboard2);
            brique2.manageMoveEffects(pos, Player.PLAYER1);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Posizione(row, col), Player.PLAYER1);

            assertEquals(expected, check);

        }

    }

    @ParameterizedTest
    @MethodSource("provideChessboardAndNotWinningPlayer")
    public void testHasPlayerNotWon(Chessboard chessboard, Player player) {
        VictoryChecker victoryChecker = new VictoryChecker(player, chessboard);

        boolean actualResult = victoryChecker.hasPlayerWon();
        boolean expectedResult = false;

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideChessboardAndNotWinningPlayer")
    public void itShouldUpdateSquare(Chessboard chessboard, int row, int col, boolean expected) {

        Posizione pos = new Posizione(4, 4);

        String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
        Chessboard chessboard2 = new Chessboard(15);

        chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

        Brique brique2 = new Brique(chessboard2);
        brique2.manageMoveEffects(pos, Player.PLAYER2);

        boolean check;

        check = chessboard2.isSquareOfPlayer(new Posizione(row, col), Player.PLAYER2);

        assertEquals(expected, check);

    }

    private static Stream<Arguments> provideChessboardForPlayer1OnWhite() {
        return Stream.of(
                Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard(), Player.PLAYER1),
                //Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard2(), Player.PLAYER1),
                Arguments.of(ChessboardTestDataFactory.createPlayer2WinningChessboard(), Player.PLAYER2)
        );
    }

    private static Stream<Arguments> provideChessboardForPlayer2OnBlack() {
        return Stream.of(
                Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard(), Player.PLAYER2),
                //Arguments.of(ChessboardTestDataFactory.createPlayer1WinningChessboard2(), Player.PLAYER2),
                Arguments.of(ChessboardTestDataFactory.createPlayer2WinningChessboard(), Player.PLAYER1)
        );
    }

    @Nested
    class TestDataFactory{

        @ParameterizedTest
        @CsvSource({
                "4,4,true", "3,3,true", "3,4,false", "2,2,false"
        })
        public void testDataFactory(int row, int col,boolean expected) {

            String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
            Chessboard chessboard2 = new Chessboard(15);

            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Posizione(row, col), Player.PLAYER2);

            assertEquals(expected, check);
        }
        @ParameterizedTest
        @CsvSource({
                "0,1,true", "1,2,true", "3,4,false", "2,2,false"
        })
        public void testDataFactory2(int row, int col,boolean expected) {

            String filePath = "src/test/resources/MatrixForPlayer1White.txt";
            Chessboard chessboard2 = new Chessboard(15);

            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

            boolean check;

            check = chessboard2.isSquareOfPlayer(new Posizione(row, col), Player.PLAYER1);

            assertEquals(expected, check);
        }

        @ParameterizedTest
        @CsvSource({
                "0,0,BLACK", "0,1,WHITE", "4,4,BLACK", "4,3,WHITE", "3,3,BLACK", "3,4,WHITE"
        })
        public void testDataFactoryColor(int r, int c, ColorSquare color) {

            String filePath = "src/test/resources/MatrixForPlayer1White.txt";
            Chessboard chessboard2 = new Chessboard(15);

            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);

            ColorSquare check;

            check = chessboard2.checkSquareColor(new Posizione(r, c));

            assertEquals(color, check);
        }

    }

//    @Nested
//    class UpdateSquareOnWhite {
//        Posizione pos = new Posizione(5, 5);
//        Player player = Player.PLAYER1;
//
//        @BeforeEach
//        public void setup() {
//            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
//            Mockito.when(chessboard.checkSquarePlayer(Mockito.any(Posizione.class))).thenReturn(player);
//            Mockito.when(chessboard.checkSquareColor(Mockito.any(Posizione.class))).thenReturn(ColorSquare.WHITE);
//        }
//
//        @Test
//        public void itShouldUpdateTheSquarePlayer() {
//            brique.manageMoveEffects(pos, player);
//
//            Mockito.verify(chessboard).updateSquarePlayer(Mockito.any(Posizione.class), Mockito.any(Player.class));
//
//
//        }
//
//    }

}
