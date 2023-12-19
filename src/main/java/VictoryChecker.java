public class VictoryChecker {

    private final Player player;
    private final Chessboard chessboard;
    private final boolean[][] mask;

    public VictoryChecker(Player player, Chessboard chessboard) {
        this.player = player;
        this.chessboard = chessboard;
        mask = new boolean[chessboard.getChessboardDimension()][chessboard.getChessboardDimension()];
    }

    public boolean hasPlayerWon() {
        for (int i = 0; i < chessboard.getChessboardDimension(); i++) {
            for (int j = 0; j < chessboard.getChessboardDimension(); j++) {
                mask[i][j] = false;
            }
        }

        if (player == Player.PLAYER1) {
            for (int j = 0; j < chessboard.getChessboardDimension(); j++) {
                Posizione startingPosition = new Posizione(0, j);
                if (hasPlayerWonFromPosition(startingPosition)) {
                    return true;
                }
            }
        }
        if (player == Player.PLAYER2) {
            for (int i = 0; i < chessboard.getChessboardDimension(); i++) {
                Posizione startingPosition = new Posizione(i, 0);
                if (hasPlayerWonFromPosition(startingPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPlayerWonFromPosition(Posizione startingPosition) {
        return chessboard.isSquareOfPlayer(startingPosition, player)
                && checkVictoryRecursive(startingPosition);
    }

    private boolean checkVictoryRecursive(Posizione position) {
        if (!chessboard.isValidPosition(position)) {
            return false;
        }

        if (isPositionAlreadyChecked(position)) {
            return false;
        } else {
            mask[position.getRow()][position.getColumn()] = true;
        }

        if (!chessboard.isSquareOfPlayer(position, player)) {
            return false;
        }

        if (position.getRow() == ((chessboard.getChessboardDimension()) - 1) && player == Player.PLAYER1) {
            return true;
        }
        if (position.getColumn() == ((chessboard.getChessboardDimension()) - 1) && player == Player.PLAYER2) {
            return true;
        }

        return checkVictoryRecursive(new Posizione(position.getRow(), position.getColumn() - 1)) ||
                checkVictoryRecursive(new Posizione(position.getRow() - 1, position.getColumn())) ||
                checkVictoryRecursive(new Posizione(position.getRow(), position.getColumn() + 1)) ||
                checkVictoryRecursive(new Posizione(position.getRow() + 1, position.getColumn()));
    }

    private boolean isPositionAlreadyChecked(Posizione position) {
        return mask[position.getRow()][position.getColumn()];
    }
}
