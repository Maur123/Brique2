import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BriqueTestFactory {

    static public Chessboard updateFullChessboard(Chessboard chessboard, String filePath) {
        try {
            // Apre il file specificato
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            int row = 0;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(" "); // Dividi la riga in base agli spazi

                int column = 0;
                for (String token : tokens) {

                    int value = Integer.parseInt(token);
                    if(value == 1) {
                        chessboard.updateSquarePlayer(new Posizione(row, column), Player.PLAYER1);
                    }
                    if(value == 2) {
                        chessboard.updateSquarePlayer(new Posizione(row, column), Player.PLAYER2);
                    }
                    column++;
                }
                row++;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            // Gestione dell'errore
        }
        return chessboard;
    }

    /*public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        String filePath = "src/test/resources/Matrix.txt"; // Inserisci il percorso del tuo file
        chessboard = updateFullChessboard(chessboard, filePath);
        System.out.println(chessboard);
    }*/
}
