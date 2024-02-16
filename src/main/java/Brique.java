public class Brique {
    private int turn;
    private Chessboard chessboard;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        turn = 1;
    }

    public void makeMove(Posizione posizione, Player player) {
        if (chessboard.isSquareAvailable(posizione)) { // Se la casella è libera
            chessboard.updateSquarePlayer(posizione, player);
            manageMoveEffects(posizione, player);
            VictoryChecker vc = new VictoryChecker(player, chessboard);
            if (vc.hasPlayerWon()) {

            }else{
                updateTurn();
            }
        }
    }

    public void manageMoveEffects(Posizione position, Player player) {
        int row = position.getRow();
        int column = position.getColumn();

        if (this.chessboard.checkSquareColor(position) == ColorSquare.WHITE) { // Casella bianca
            if (this.chessboard.isSquareOfPlayer(new Posizione(row - 1, column - 1), player) || this.chessboard.isSquareOfPlayer(new Posizione(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row - 1, column), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Posizione(row + 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }

        } else if (this.chessboard.checkSquareColor(position) == ColorSquare.BLACK) { // Casella nera
            if (this.chessboard.isSquareOfPlayer(new Posizione(row + 1, column - 1), player) || this.chessboard.isSquareOfPlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row + 1, column), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Posizione(row - 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Posizione(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }
        }
    }

    private void updateTurn() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }

    public void resetGame() {
        turn = 1;
        chessboard.cleanChessboard();
    }
}
