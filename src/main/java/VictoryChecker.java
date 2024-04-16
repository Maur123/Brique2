public class VictoryChecker {
    private final Chessboard chessboard;
    private final boolean[][] mask;

    public VictoryChecker(Chessboard chessboard) {
        this.chessboard = chessboard;
        mask = new boolean[chessboard.getChessboardDimension()][chessboard.getChessboardDimension()];
    }

    public boolean hasPlayerWon(Player player) {
        resetMask();

        if (player == Player.PLAYER1) {
            for (int column = 0; column < chessboard.getChessboardDimension(); column++) {
                Position startingPosition = new Position(0, column);
                if (hasPlayerWonFromPosition(startingPosition, player)) {
                    return true;
                }
            }
        } else if (player == Player.PLAYER2) {
            for (int row = 0; row < chessboard.getChessboardDimension(); row++) {
                Position startingPosition = new Position(row, 0);
                if (hasPlayerWonFromPosition(startingPosition, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetMask() {
        for (int i = 0; i < chessboard.getChessboardDimension(); i++) {
            for (int j = 0; j < chessboard.getChessboardDimension(); j++) {
                mask[i][j] = false;
            }
        }
    }

    private boolean hasPlayerWonFromPosition(Position startingPosition, Player player) {
        return chessboard.isSquareOfPlayer(startingPosition, player)
                && checkVictoryRecursive(startingPosition, player);
    }

    private boolean checkVictoryRecursive(Position position, Player player) {
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

        return checkVictoryRecursive(new Position(position.getRow(), position.getColumn() - 1), player) ||
                checkVictoryRecursive(new Position(position.getRow() - 1, position.getColumn()), player) ||
                checkVictoryRecursive(new Position(position.getRow(), position.getColumn() + 1), player) ||
                checkVictoryRecursive(new Position(position.getRow() + 1, position.getColumn()), player);
    }

    private boolean isPositionAlreadyChecked(Position position) {
        return mask[position.getRow()][position.getColumn()];
    }
}
