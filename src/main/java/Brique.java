public class Brique {
    private final Chessboard chessboard;
    private final MoveEffectsManager moveEffectsManager;
    private final VictoryChecker victoryChecker;
    private int turn;
    private boolean victory;

    public Brique(Chessboard chessboard) {
        this.chessboard = chessboard;
        this.moveEffectsManager = new MoveEffectsManager(this.chessboard);
        this.victoryChecker = new VictoryChecker(this.chessboard);
        turn = 1;
        victory = false;
    }

    public void makeMove(Position position, Player player) {
        if (chessboard.isSquareAvailable(position)) {
            chessboard.updateSquarePlayer(position, player);
            moveEffectsManager.update(position, player);
            if (victoryChecker.hasPlayerWon(player)) {
                victory = true;
            } else {
                turn++;
            }
        }
    }

    public int getTurn() {
        return turn;
    }

    public boolean isVictory() {
        return victory;
    }

    public void resetGame() {
        turn = 1;
        victory = false;
        chessboard.cleanChessboard();
    }

    public Chessboard getChessboard() {
        return chessboard;
    }
}
