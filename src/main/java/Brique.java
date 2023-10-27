public class Brique {
    private int turn;
    private Chessboard chessboard;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        turn = 0;
    }

    public void makeMove(Posizione posizione, Player player) {
        if (this.chessboard.checkSquarePlayer(posizione) == null) { // Se la casella è libera
            this.chessboard.updateSquarePlayer(posizione, player);
            checkMove2(posizione, player);
        }
    }
    public void checkMove(){
        this.chessboard.updateSquarePlayer(new Posizione(1, 1), Player.PLAYER1);
    }
    public void checkMove2(Posizione position, Player player){
        int row = position.getRow();
        int column = position.getColumn();

        if (this.chessboard.checkSquareColor(position) == Color.WHITE) { // Casella bianca
            if (isSamePlayer(new Posizione(row - 1, column - 1), player) || isSamePlayer(new Posizione(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row - 1, column), player);
            }
            else if (isSamePlayer(new Posizione(row + 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            else if (isSamePlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }


        } else if (this.chessboard.checkSquareColor(position) == Color.BLACK) { // Casella nera
            if (isSamePlayer(new Posizione(row + 1, column - 1), player) || isSamePlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row + 1, column), player);
            }
            else if (isSamePlayer(new Posizione(row - 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            else if (isSamePlayer(new Posizione(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }
        }
    }

    public boolean isSamePlayer(Posizione posizione, Player player) {
        if (this.chessboard.isValidPosition(posizione)) {
            return this.chessboard.checkSquarePlayer(posizione) == player;
        }
        return false;
    }

    public boolean checkVictoryPlayer1(Player player) {

        boolean[][] mask = new boolean[chessboard.getDIMENSION()][chessboard.getDIMENSION()];
        for (int i = 0; i < chessboard.getDIMENSION(); i++) {
            for (int j = 0; j < chessboard.getDIMENSION(); j++) {
                mask[i][j] = false;
            }
        }

        for (int j = 0; j < chessboard.getDIMENSION(); j++) {
            if (chessboard.checkSquarePlayer(new Posizione(0, j)) == player) {
                checkVictoryRecursive(player, new Posizione(0, j), mask);
            }
        }

        return true;
    }

    private boolean checkVictoryRecursive(Player player, Posizione position, boolean[][] mask) {
        if (chessboard.isValidPosition(position) == true)
            if (chessboard.checkSquarePlayer(position) == player)
                if (mask[position.getRow()][position.getColumn()] = false)

                    mask[position.getRow()][position.getColumn()] = true;
                    checkVictoryRecursive(player, new Posizione(position.getRow(), position.getColumn() - 1), mask);
                    checkVictoryRecursive(player, new Posizione(position.getRow() - 1, position.getColumn()), mask);
                    checkVictoryRecursive(player, new Posizione(position.getRow(), position.getColumn() + 1), mask);
                    checkVictoryRecursive(player, new Posizione(position.getRow() + 1, position.getColumn()), mask);

        return true;
    }
}
