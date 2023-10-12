public class Brique extends Chessboard {
    private int turn;

    public Brique() {
        super();
        turn = 0;
    }

    public void makeMove(Posizione posizione, Player player) {
        if (checkSquarePlayer(posizione) == null) { // Se la casella è libera
            updateSquarePlayer(posizione, player);

            int riga = posizione.getRow();
            int colonna = posizione.getColumn();

            if (checkSquareColor(posizione) == Color.WHITE) { // Casella bianca
                if (isSamePlayer(new Posizione(riga - 1, colonna - 1), player) &&
                        isSamePlayer(new Posizione(riga - 1, colonna + 1), player) &&
                        isSamePlayer(new Posizione(riga + 1, colonna - 1), player) &&
                        isSamePlayer(new Posizione(riga + 1, colonna + 1), player)) {
                    // Occupa anche la casella sopra la diagonale
                    updateSquarePlayer(new Posizione(riga - 1, colonna), player);
                }
            } else if (checkSquareColor(posizione) == Color.BLACK) { // Casella nera
                if (isSamePlayer(new Posizione(riga - 1, colonna - 1), player) &&
                        isSamePlayer(new Posizione(riga - 1, colonna + 1), player) &&
                        isSamePlayer(new Posizione(riga + 1, colonna - 1), player) &&
                        isSamePlayer(new Posizione(riga + 1, colonna + 1), player)) {
                    // Occupa anche la casella sotto la diagonale
                    updateSquarePlayer(new Posizione(riga + 1, colonna), player);
                }
            }
        }
    }

    private boolean isSamePlayer(Posizione posizione, Player player) {
        if (posizione.getRow() >= 0 && posizione.getRow() < getDIMENSION() &&
                posizione.getColumn() >= 0 && posizione.getColumn() < getDIMENSION()) {
            return checkSquarePlayer(posizione) == player;
        }
        return false;
    }

}
