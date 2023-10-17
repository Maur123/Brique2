public class Chessboard {
    private static final int DIMENSION = 15;
    private Square[][] table;

    public Chessboard(){
        createChessboard();
        initChessboard();
    }

    private void createChessboard() {
        this.table = new Square[DIMENSION][DIMENSION];
    }

    private void initChessboard() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    table[i][j] = new Square(Color.BLACK);
                } else {
                    table[i][j] = new Square(Color.WHITE);
                }
            }
        }
    }

    public void updateSquarePlayer(Posizione posizione, Player player) {
        if (isValidPosition(posizione)) {
            this.table[posizione.getRow()][posizione.getColumn()].occupy(player);
        } else {
            // Tratta il caso in cui la posizione non sia valida
            System.out.println("Posizione non valida");
        }
    }

    public Player checkSquarePlayer(Posizione posizione) {
        if (isValidPosition(posizione)) {
            return this.table[posizione.getRow()][posizione.getColumn()].getPlayer();
        } else {
            // Tratta il caso in cui la posizione non sia valida
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public Color checkSquareColor(Posizione posizione) {
        if (isValidPosition(posizione)) {
            return this.table[posizione.getRow()][posizione.getColumn()].getColor();
        } else {
            // Tratta il caso in cui la posizione non sia valida
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public boolean isValidPosition(Posizione posizione) {
        int row = posizione.getRow();
        int column = posizione.getColumn();
        return row >= 0 && row < DIMENSION && column >= 0 && column < DIMENSION;
    }


}
