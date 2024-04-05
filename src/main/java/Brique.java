public class Brique {
    private final Chessboard chessboard;
    private int turn;
    private boolean victory;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        turn = 1;
        victory = false;
    }

    public void makeMove(Position position, Player player) {
        if (chessboard.isSquareAvailable(position)) {
            chessboard.updateSquarePlayer(position, player);
            manageMoveEffects(position, player);
            VictoryChecker vc = new VictoryChecker(player, chessboard);
            if (vc.hasPlayerWon()) {
                victory = true;
            } else {
                updateTurn();
            }
        }
    }

    public void manageMoveEffects(Position position, Player player) {
        int row = position.getRow();
        int column = position.getColumn();

        if (this.chessboard.checkSquareColor(position) == ColorSquare.WHITE) {
            if (this.chessboard.isSquareOfPlayer(new Position(row - 1, column - 1), player) || this.chessboard.isSquareOfPlayer(new Position(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row - 1, column), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Position(row + 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row, column - 1), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Position(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row, column + 1), player);
            }

        } else if (this.chessboard.checkSquareColor(position) == ColorSquare.BLACK) {
            if (this.chessboard.isSquareOfPlayer(new Position(row + 1, column - 1), player) || this.chessboard.isSquareOfPlayer(new Position(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row + 1, column), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Position(row - 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row, column - 1), player);
            }
            if (this.chessboard.isSquareOfPlayer(new Position(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Position(row, column + 1), player);
            }
        }
    }

    private void updateTurn() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isVictory() {
        return victory;
    }

    public void resetGame() {
        turn = 1;
        victory = false;
        chessboard.cleanChessboard();
    }

    public Chessboard getChessboard() {
        return chessboard;
    }
}
