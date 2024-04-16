public class MoveEffectsManager {
    private final Chessboard chessboard;

    public MoveEffectsManager(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void update(Position position, Player player) {
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

}
