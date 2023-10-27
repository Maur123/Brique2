import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BriqueTest {
    Brique brique;
    @Mock
    Chessboard chessboard;
    @BeforeEach
    public void setup() {
        chessboard = mock(Chessboard.class);
        brique = new Brique(chessboard);
    }
    @Nested
    class WhenSquareIsNull {
        Posizione pos = new Posizione(5, 5);
        Player player = Player.PLAYER1;
        @BeforeEach
        public void setup() {
            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(null);
        }

        @Test
        public void itShouldUpdateTheSquarePlayer() {
            brique.makeMove(pos, player);

            Mockito.verify(chessboard).updateSquarePlayer(pos, player);

        }
    }

    @Nested
    class CheckThatisSamePlayer {
        Posizione pos = new Posizione(5, 5);
        Player player = Player.PLAYER1;
        @BeforeEach
        public void setup() {
            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(player);
            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
        }
        @Test
        public void itShouldUpdateTheSquarePlayer() {
            boolean response = brique.isSamePlayer(pos, player);


            assertEquals(true, response);

        }
    }

    @Nested
    class UpdateSquareOnWhite2{
        Posizione pos = new Posizione(5, 5);
        /*Posizione pos1 = new Posizione(4, 4);
        Posizione pos2 = new Posizione(4, 6);
        Posizione pos3 = new Posizione(6, 4);
        Posizione pos4 = new Posizione(6, 6);
        Posizione finals =  new Posizione(4, 5);*/
        Player player = Player.PLAYER2;
        @BeforeEach
        public void setup() {
            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
            Mockito.when(chessboard.checkSquarePlayer(Mockito.any(Posizione.class))).thenReturn(player);
            Mockito.when(chessboard.checkSquareColor(Mockito.any(Posizione.class))).thenReturn(Color.WHITE);
            /*Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(player);
            Mockito.when(chessboard.checkSquarePlayer(pos1)).thenReturn(player);
            Mockito.when(chessboard.checkSquarePlayer(pos2)).thenReturn(player);
            Mockito.when(chessboard.checkSquarePlayer(pos3)).thenReturn(player);
            Mockito.when(chessboard.checkSquarePlayer(pos4)).thenReturn(player);*/
        }
        @Test
        public void itShouldUpdateTheSquarePlayer() {
            brique.checkMove2(pos,player);

            Mockito.verify(chessboard).updateSquarePlayer(Mockito.any(Posizione.class), Mockito.any(Player.class));


        }

    }

    @Nested
    class UpdateSquareOnWhite{
        Posizione pos = new Posizione(5, 5);
        Player player = Player.PLAYER1;
        @BeforeEach
        public void setup() {
            Mockito.when(chessboard.isValidPosition(Mockito.any(Posizione.class))).thenReturn(true);
            Mockito.when(chessboard.checkSquarePlayer(Mockito.any(Posizione.class))).thenReturn(player);
            Mockito.when(chessboard.checkSquareColor(Mockito.any(Posizione.class))).thenReturn(Color.WHITE);
        }
        @Test
        public void itShouldUpdateTheSquarePlayer() {
            brique.checkMove();

            Mockito.verify(chessboard).updateSquarePlayer(Mockito.any(Posizione.class), Mockito.any(Player.class));


        }

    }

    @Test
    public void testCheckMove() {
        // Crea un mock per la classe Chessboard

        Chessboard chessboard = mock(Chessboard.class);

        // Crea un'istanza di Brique con il mock di Chessboard
        Brique brique = new Brique(chessboard);

        // Chiamata al metodo checkMove
        brique.checkMove();

        // Verifica che il metodo updateSquarePlayer sia stato chiamato con i parametri corretti
        verify(chessboard).updateSquarePlayer(new Posizione(1, 1), Player.PLAYER1);

        // Puoi aggiungere ulteriori asserzioni o verifiche a seconda delle tue esigenze
    }

    @Nested
    class checkVictory{

        Player player = Player.PLAYER1;
        @BeforeEach
        /*public void setup() {
            Mockito.when(chessboard.checkSquarePlayer(pos)).thenReturn(null);
        }*/
        @Disabled
        @Test
        public void checkvictoy(){

            boolean victory;
            victory = brique.checkVictoryPlayer1(player);

            assertEquals(true, victory);
        }


    }




//    @Disabled
//    @Test
//    public void makemove2() {
//        Brique brique = new Brique();
//
//        brique.updateSquarePlayer(new Posizione(4, 4), Player.PLAYER1);
//        brique.makeMove(new Posizione(5, 5), Player.PLAYER1);
//
//        Player actualPlayer = brique.checkSquarePlayer(new Posizione(5, 4));
//        Player expectedPlayer = Player.PLAYER1;
//
//        assertEquals(expectedPlayer, actualPlayer);
//    }
}
