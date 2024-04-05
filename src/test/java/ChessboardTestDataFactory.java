import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChessboardTestDataFactory {

    public static Chessboard createPlayer1WinningChessboard() {
        String filePath = "src/test/resources/MatrixWinningPlayer1.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    public static Chessboard createPlayer2WinningChessboard() {
        String filePath = "src/test/resources/MatrixWinningPlayer2.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnWhiteOfPlayer1() {
        String filePath = "src/test/resources/MatrixForPlayer1White.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnWhiteOfPlayer2() {
        String filePath = "src/test/resources/MatrixForPlayer2White.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnBlackOfPlayer1() {
        String filePath = "src/test/resources/MatrixForPlayer1Black.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnBlackOfPlayer2() {
        String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
        Chessboard chessboard = new Chessboard(15);
        return fillChessboardFromFile(chessboard, filePath);
    }

    private static Chessboard fillChessboardFromFile(Chessboard chessboard, String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            int row = 0;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(" ");

                int column = 0;
                for (String token : tokens) {

                    int value = Integer.parseInt(token);
                    if (value == 1) {
                        chessboard.updateSquarePlayer(new Position(row, column), Player.PLAYER1);
                    }
                    if (value == 2) {
                        chessboard.updateSquarePlayer(new Position(row, column), Player.PLAYER2);
                    }
                    column++;
                }
                row++;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return chessboard;
    }

}
