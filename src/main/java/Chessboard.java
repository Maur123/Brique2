public class Chessboard {
    private Square[][] table;
    private final int chessboardDimension;

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

    private Square getSquare(Position position) {
        return this.table[position.getRow()][position.getColumn()];
    }

    public int getChessboardDimension() {
        return chessboardDimension;
    }

    public ColorSquare checkSquareColor(Position position) {
        if (isValidPosition(position)) {
            return getSquare(position).getColor();
        } else {
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public Player checkSquarePlayer(Position position) {
        if (isValidPosition(position)) {
            return getSquare(position).getPlayer();
        } else {
            System.out.println("Posizione non valida");
            return null;
        }
    }

    public void updateSquarePlayer(Position position, Player player) {
        if (isValidPosition(position)) {
            getSquare(position).occupy(player);
        } else {
            System.out.println("Posizione non valida");
        }
    }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row >= 0 && row < chessboardDimension && column >= 0 && column < chessboardDimension;
    }

    public boolean isSquareOfPlayer(Position position, Player player) {
        return this.checkSquarePlayer(position) == player;
    }

    public boolean isSquareAvailable(Position position) {
        return getSquare(position).isFree();
    }

    public void cleanChessboard() {
        for (int i = 0; i < chessboardDimension; i++) {
            for (int j = 0; j < chessboardDimension; j++) {
                this.table[i][j].makePlayerNull();
            }
        }
    }



}
