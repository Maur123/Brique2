public class ChessboardTestDataFactory {

    public static Chessboard createPlayer1WinningChessboard(){
        String filePath = "src/test/resources/MatrixWinningPlayer1.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

    public static Chessboard createPlayer2WinningChessboard(){
        String filePath = "src/test/resources/MatrixWinningPlayer2.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

    /*public static Chessboard createPlayer1WinningChessboard2(){
        Chessboard chessboard = new Chessboard(15);

        chessboard.updateSquarePlayer(new Posizione(0, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(1, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(2, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(3, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(4, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(5, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(6, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(7, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(8, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(9, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(10, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(11, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(12, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(13, 6), Player.PLAYER1);
        chessboard.updateSquarePlayer(new Posizione(14, 6), Player.PLAYER1);
        return chessboard;
    }*/

    public static Chessboard createChessboardForManageMoveOnWhiteOfPlayer1(){
        String filePath = "src/test/resources/MatrixForPlayer1White.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnWhiteOfPlayer2(){
        String filePath = "src/test/resources/MatrixForPlayer2White.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnBlackOfPlayer1(){
        String filePath = "src/test/resources/MatrixForPlayer1Black.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

    public static Chessboard createChessboardForManageMoveOnBlackOfPlayer2(){
        String filePath = "src/test/resources/MatrixForPlayer2Black.txt";
        Chessboard chessboard = new Chessboard(15);
        return BriqueTestFactory.updateFullChessboard(chessboard, filePath);
    }

}
