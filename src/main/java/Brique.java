public class Brique {
    private int turn;
    private Chessboard chessboard;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        turn = 1;
    }

    public void makeMove(Posizione posizione, Player player) {
        if (this.chessboard.checkSquarePlayer(posizione) == null) { // Se la casella è libera
            this.chessboard.updateSquarePlayer(posizione, player);
            checkMove(posizione, player);
            if(checkVictoryPlayer(player)){

            }
            updateTurn();
        }
    }

    /*public void checkMove(){
        this.chessboard.updateSquarePlayer(new Posizione(1, 1), Player.PLAYER1);
    }*/
    public void checkMove(Posizione position, Player player){
        int row = position.getRow();
        int column = position.getColumn();

        if (this.chessboard.checkSquareColor(position) == ColorSquare.WHITE) { // Casella bianca
            if (isSamePlayer(new Posizione(row - 1, column - 1), player) || isSamePlayer(new Posizione(row - 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row - 1, column), player);
            }
            else if (isSamePlayer(new Posizione(row + 1, column - 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            else if (isSamePlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }


        } else if (this.chessboard.checkSquareColor(position) == ColorSquare.BLACK) { // Casella nera
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

    public boolean checkVictoryPlayer(Player player) {

        boolean[][] mask = new boolean[chessboard.getDIMENSION()][chessboard.getDIMENSION()];
        for (int i = 0; i < chessboard.getDIMENSION(); i++) {
            for (int j = 0; j < chessboard.getDIMENSION(); j++) {
                mask[i][j] = false;
            }
        }

        if(player == Player.PLAYER1) {
            for (int j = 0; j < chessboard.getDIMENSION(); j++) {
                if (chessboard.checkSquarePlayer(new Posizione(0, j)) == player) {
                    if (checkVictoryRecursive(player, new Posizione(0, j), mask)) {
                        return true;
                    }
                }
            }
        }
        if(player == Player.PLAYER2) {
            for (int i = 0; i < chessboard.getDIMENSION(); i++) {
                if (chessboard.checkSquarePlayer(new Posizione(i, 0)) == player) {
                    if (checkVictoryRecursive(player, new Posizione(i, 0), mask)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkVictoryRecursive(Player player, Posizione position, boolean[][] mask) {

        System.out.println(position.getRow() + " e " + position.getColumn());

        if (chessboard.isValidPosition(position) == false) {
            return false;
        }

        if(mask[position.getRow()][position.getColumn()] == true) {
            return false;
        }
        else {
            mask[position.getRow()][position.getColumn()] = true;
        }

        if (chessboard.checkSquarePlayer(position) != player) {
            return false;
        }

        if (position.getRow() == ((chessboard.getDIMENSION())-1) && player==Player.PLAYER1) {
            return true;
        }
        if (position.getColumn() == ((chessboard.getDIMENSION())-1) && player==Player.PLAYER2) {
            return true;
        }

        return      checkVictoryRecursive(player, new Posizione(position.getRow(), position.getColumn() - 1), mask) ||
                    checkVictoryRecursive(player, new Posizione(position.getRow() - 1, position.getColumn()), mask) ||
                    checkVictoryRecursive(player, new Posizione(position.getRow(), position.getColumn() + 1), mask) ||
                    checkVictoryRecursive(player, new Posizione(position.getRow() + 1, position.getColumn()), mask);
    }

    private void updateTurn() {
        turn++;
    }
    public int getTurn() {
        return turn;
    }

    // da testare...
    public void resetGame(){
        turn = 1;
        chessboard.cleanChessboard();
    }
}
