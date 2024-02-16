public class Chessboard {
    private Square[][] table;
    private int chessboardDimension;

    public Chessboard(int chessboardDimension) {
        this.chessboardDimension = chessboardDimension;
        createChessboard();
        initChessboard();
    }

    private void createChessboard() {
        this.table = new Square[chessboardDimension][chessboardDimension];
    }

    private void initChessboard() {
        for (int i = 0; i < chessboardDimension; i++) {
            for (int j = 0; j < chessboardDimension; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    table[i][j] = new Square(ColorSquare.BLACK);
                } else {
                    table[i][j] = new Square(ColorSquare.WHITE);
                }
            }
        }
    }

    private Square getSquare(Posizione posizione) {
        return this.table[posizione.getRow()][posizione.getColumn()];
    }

    public int getChessboardDimension(){
        return chessboardDimension;
    }

    public ColorSquare checkSquareColor(Posizione posizione) {
        if (isValidPosition(posizione)) {
            return getSquare(posizione).getColor();
        } else {
            // Tratta il caso in cui la posizione non sia valida
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public Player checkSquarePlayer(Posizione posizione) {
        if (isValidPosition(posizione)) {
            return getSquare(posizione).getPlayer();
        } else {
            // Tratta il caso in cui la posizione non sia valida
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public void updateSquarePlayer(Posizione posizione, Player player) {
        if (isValidPosition(posizione)) {
            getSquare(posizione).occupy(player);
        } else {
            System.out.println("Posizione non valida");
        }
    }

    public boolean isValidPosition(Posizione posizione) {
        int row = posizione.getRow();
        int column = posizione.getColumn();
        return row >= 0 && row < chessboardDimension && column >= 0 && column < chessboardDimension;
    }

    public boolean isSquareOfPlayer(Posizione posizione, Player player) {
        return this.checkSquarePlayer(posizione) == player;
    }

    public boolean isSquareAvailable(Posizione posizione) {
        return getSquare(posizione).isFree();
    }

    public void cleanChessboard() {
        for (int i = 0; i < chessboardDimension; i++) {
            for (int j = 0; j < chessboardDimension; j++) {
                this.table[i][j].makePlayerNull();
            }
        }
    }



}
