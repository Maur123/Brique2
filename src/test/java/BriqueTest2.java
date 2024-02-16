//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
////@RunWith(MockitoJUnitRunner.class)
//public class BriqueTest2 {
//    Brique brique;
//    //@Mock
//    Chessboard chessboard;
//
//    @BeforeEach
//    public void setup() {
//        //chessboard = mock(Chessboard.class);
//        chessboard = new Chessboard(15);
//        brique = new Brique(chessboard);
//    }
//
//    @Nested
//    class TestMakeMove {
//
//        @ParameterizedTest
//        @CsvSource({
//                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER2", "6,4,PLAYER2"
//        })
//        public void itShouldUpdateTheSquarePlayer(int row, int column, Player player) {
//            Posizione pos = new Posizione(row, column);
//
//            brique.makeMove(pos, player);
//            Player updatedPlayer = chessboard.checkSquarePlayer(pos);
//
//            assertNotEquals(null, updatedPlayer);
//        }
//
//        @ParameterizedTest
//        @CsvSource({
//                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER2", "6,4,PLAYER2"
//        })
//        public void itShouldUpdateTheSquarePlayer2(int row, int column, Player player) {
//            Posizione pos = new Posizione(row, column);
//
//            brique.makeMove(pos, player);
//            Player updatedPlayer = chessboard.checkSquarePlayer(pos);
//
//            assertEquals(player, updatedPlayer);
//        }
//    }
//
//    /*@Nested
//    class CheckThatisSamePlayer1 {
//        String filePath = "src/test/resources/MatrixAllPlayer1.txt";
//        Chessboard updatedChessboard = new Chessboard();
//
//        @BeforeEach
//        public void setup() {
//            updatedChessboard = BriqueTestFactory.updateFullChessboard(updatedChessboard, filePath);
//        }
//
//        @ParameterizedTest
//        @CsvSource({
//                "7,4,PLAYER1", "2,11,PLAYER1", "5,5,PLAYER1", "6,4,PLAYER1"
//        })
//        public void itShouldUpdateTheSquarePlayer(int row, int column, Player player) {
//
//            Brique brique2 = new Brique(updatedChessboard);
//            Posizione pos = new Posizione(row, column);
//            boolean response = brique2.isSquareOfPlayer(pos, player);
//
//            assertEquals(true, response);
//        }
//    }*/
//
//    @Nested
//    class UpdateSquareOnWhite2 {
//        Posizione pos = new Posizione(5, 5);
//        Posizione pos1 = new Posizione(4, 4);
//        Posizione pos2 = new Posizione(4, 6);
//        Posizione pos3 = new Posizione(6, 4);
//        Posizione pos4 = new Posizione(6, 6);
//        Posizione finals =  new Posizione(4, 5);
//        Player player = Player.PLAYER2;
//        @BeforeEach
//        public void setup() {
//            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
//            //Mockito.when(chessboard.checkSquarePlayer(Mockito.any(Posizione.class))).thenReturn(player);
//            Mockito.when(chessboard.checkSquareColor(Mockito.any(Posizione.class))).thenReturn(ColorSquare.WHITE);
//            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(player);
//            Mockito.when(chessboard.checkSquarePlayer(pos1)).thenReturn(player);
//            Mockito.when(chessboard.checkSquarePlayer(pos2)).thenReturn(player);
//            Mockito.when(chessboard.checkSquarePlayer(pos3)).thenReturn(player);
//            Mockito.when(chessboard.checkSquarePlayer(pos4)).thenReturn(player);
//        }
//
//
//        @Test
//        public void itShouldUpdateTheSquarePlayer() {
//
//            Posizione pos = new Posizione(4, 4);
//
//            String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
//            Chessboard chessboard2 = new Chessboard(15);
//
//            chessboard2 = BriqueTestFactory.updateFullChessboard(chessboard2, filePath);
//
//            Brique brique2 = new Brique(chessboard2);
//            brique2.manageMoveEffects(pos, Player.PLAYER2);
//
//            //boolean check;
//            boolean check2;
//
//            //check = brique2.isSquareOfPlayer(new Posizione(3, 4), Player.PLAYER2);
//            check2 = chessboard2.isSquareOfPlayer(new Posizione(3, 4), Player.PLAYER2);
//
//            assertEquals(true, check2);
//
//            //Mockito.verify(chessboard).updateSquarePlayer(finals, player);
//        }
//
//    }
//
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
//
//}
