public class Brique {
    private int turn;
    private final Chessboard chessboard;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        turn = 0;
    }

    public void makeMove(Posizione posizione, Player player) {
        if (this.chessboard.checkSquarePlayer(posizione) == null) { // Se la casella è libera
            this.chessboard.updateSquarePlayer(posizione, player);
            checkMove(posizione, player);
        }
    }

    public void checkMove(Posizione position, Player player){
        int row = position.getRow();
        int column = position.getColumn();

        if (this.chessboard.checkSquareColor(position) == Color.WHITE) { // Casella bianca
            if (isSamePlayer(new Posizione(row - 1, column - 1), player) || isSamePlayer(new Posizione(row - 1, column + 1), player)){
                this.chessboard.updateSquarePlayer(new Posizione(row - 1, column), player);
            }
            if(isSamePlayer(new Posizione(row + 1, column - 1), player)){
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            if(isSamePlayer(new Posizione(row + 1, column + 1), player)) {
                this.chessboard.updateSquarePlayer(new Posizione(row, column + 1), player);
            }


        } else if (this.chessboard.checkSquareColor(position) == Color.BLACK) { // Casella nera
            if (isSamePlayer(new Posizione(row + 1, column - 1), player) || isSamePlayer(new Posizione(row + 1, column + 1), player)){
                this.chessboard.updateSquarePlayer(new Posizione(row + 1, column), player);
            }
            if(isSamePlayer(new Posizione(row - 1, column - 1), player)){
                this.chessboard.updateSquarePlayer(new Posizione(row, column - 1), player);
            }
            if(isSamePlayer(new Posizione(row - 1, column + 1), player)) {
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
}
