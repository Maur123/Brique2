//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BriqueTest {
//    Brique brique;
//    @Mock
//    Chessboard chessboard;
//    @BeforeEach
//    public void setup() {
//        chessboard = mock(Chessboard.class);
//        brique = new Brique(chessboard);
//    }
//    @Nested
//    class WhenSquareIsNull {
//        Posizione pos = new Posizione(5, 5);
//        Player player = Player.PLAYER1;
//        @BeforeEach
//        public void setup() {
//            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(null);
//        }
//
//        @Test
//        public void itShouldUpdateTheSquarePlayer() {
//            brique.makeMove(pos, player);
//
//            Mockito.verify(chessboard).updateSquarePlayer(pos, player);
//
//        }
//    }
//
//    @Nested
//    class CheckThatisSamePlayer {
//        Posizione pos = new Posizione(5, 5);
//        Player player = Player.PLAYER1;
//        @BeforeEach
//        public void setup() {
//            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(player);
//            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
//        }
//        @Test
//        public void itShouldUpdateTheSquarePlayer() {
//            boolean response = brique.isSquareOfPlayer(pos, player);
//
//
//            assertEquals(true, response);
//
//        }
//    }
//
//    @Nested
//    class UpdateSquareOnWhite2{
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
//        @Test
//        public void itShouldUpdateTheSquarePlayer() {
//            brique.manageMoveEffects(pos,player);
//
//            Mockito.verify(chessboard).updateSquarePlayer(finals, player);
//
//
//        }
//
//    }
//
//    @Nested
//    class UpdateSquareOnWhite{
//        Posizione pos = new Posizione(5, 5);
//        Player player = Player.PLAYER1;
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
//    /*
//    @Test
//    public void testCheckMove() {
//        // Crea un mock per la classe Chessboard
//
//        Chessboard chessboard = mock(Chessboard.class);
//
//        // Crea un'istanza di Brique con il mock di Chessboard
//        Brique brique = new Brique(chessboard);
//
//        // Chiamata al metodo checkMove
//        brique.checkMove2();
//
//        // Verifica che il metodo updateSquarePlayer sia stato chiamato con i parametri corretti
//        verify(chessboard).updateSquarePlayer(new Posizione(1, 1), Player.PLAYER1);
//
//        // Puoi aggiungere ulteriori asserzioni o verifiche a seconda delle tue esigenze
//    }*/
//
//    @Nested
//    class checkNotVictory{
//
//        Player player = Player.PLAYER1;
//        @BeforeEach
//        /*public void setup() {
//            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(null);
//        }*/
//        @Test
//        public void checkvictory(){
//
//            boolean victory;
//            victory = brique.checkVictoryPlayer(player);
//
//            assertEquals(false, victory);
//        }
//
//
//    }
//
//    @Nested
//    class checkVictory{
//
//        Posizione pos = new Posizione(0, 6);
//        Posizione pos1 = new Posizione(1, 6);
//        Posizione pos2 = new Posizione(2, 6);
//        Posizione pos3 = new Posizione(3, 6);
//        Posizione pos4 = new Posizione(4, 6);
//        Posizione pos5 = new Posizione(5, 6);
//        Posizione pos6 = new Posizione(6, 6);
//        Posizione pos7 = new Posizione(7, 6);
//        Posizione pos8 = new Posizione(8, 6);
//        Posizione pos9 = new Posizione(9, 6);
//        Posizione pos10 =  new Posizione(10, 6);
//        Posizione pos11 = new Posizione(11, 6);
//        Posizione pos12 = new Posizione(12, 6);
//        Posizione pos13 = new Posizione(13, 6);
//        Posizione pos14 = new Posizione(14, 6);
//
//        Player player = Player.PLAYER1;
//        @BeforeEach
//        public void setup() {
//
//            Mockito.when(chessboard.isValidPosition(pos)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos1)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos2)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos3)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos4)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos5)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos6)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos7)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos8)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos9)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos10)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos11)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos12)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos13)).thenReturn(true);
//            Mockito.when(chessboard.isValidPosition(pos14)).thenReturn(true);
//            //Mockito.when(chessboard.isValidPosition(new Posizione(15, 6))).thenReturn(true);
//
//            Mockito.when(chessboard.checkSquarePlayer(Mockito.any(Posizione.class))).thenReturn(player);
//            Mockito.when(chessboard.getChessboardDimension()).thenReturn(15);
//        }
//
//        @Test
//        public void checkvictory(){
//
//            boolean victory;
//            victory = brique.checkVictoryPlayer(player);
//
//            assertEquals(true, victory);
//        }
//
//
//    }
//
//
//    @Test
//    public void singlecheckvictory(){
//
//        Chessboard chessboard = new Chessboard();
//
//        chessboard.updateSquarePlayer(new Posizione(0,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(1,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(2,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(3,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(4,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(5,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(6,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(7,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(8,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(9,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(10,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(11,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(12,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(13,6), Player.PLAYER1);
//        chessboard.updateSquarePlayer(new Posizione(14,6), Player.PLAYER1);
//
//
//        Brique brique = new Brique(chessboard);
//
//        boolean check;
//
//        check = brique.checkVictoryPlayer(Player.PLAYER1);
//
//        assertEquals(true, check);
//    }
//
//    @Nested
//    class Multiplecheckvictory {
//        @Test
//        public void firstvictoryPlayer1() {
//
//            String filePath = "src/test/resources/MatrixWinningPlayer1.txt";
//            Chessboard chessboard = new Chessboard();
//
//            chessboard = BriqueTestFactory.updateFullChessboard(chessboard, filePath);
//
//            Brique brique = new Brique(chessboard);
//
//            boolean check;
//
//            check = brique.checkVictoryPlayer(Player.PLAYER1);
//
//            assertEquals(true, check);
//        }
//
//        @Test
//        public void firstrvictoryPlayer2() {
//
//            String filePath = "src/test/resources/MatrixWinningPlayer2.txt";
//            Chessboard chessboard = new Chessboard();
//
//            chessboard = BriqueTestFactory.updateFullChessboard(chessboard, filePath);
//
//            Brique brique = new Brique(chessboard);
//
//            boolean check;
//
//            check = brique.checkVictoryPlayer(Player.PLAYER2);
//
//            assertEquals(true, check);
//        }
//    }
//
//}
