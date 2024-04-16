import javax.swing.*;
import java.util.Objects;

public class Controller {
    private final Brique brique;
    private final int CHESSBOARD_SIZE = 15;
    private final Graphic graphic;
    private final Icon player1Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/pedinarossa.png")));
    private final Icon player2Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/pedinanera.png")));


    public Controller() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE);
        brique = new Brique(chessboard);
        graphic = new Graphic(CHESSBOARD_SIZE);
        initGraphic();
    }

    private void initGraphic() {
        graphic.restartButton.addActionListener(e -> restartGame());
        graphic.quitButton.addActionListener(e -> quitGame());
        for (int row = 0; row < CHESSBOARD_SIZE; row++) {
            for (int column = 0; column < CHESSBOARD_SIZE; column++) {
                final int r = row;
                final int c = column;
                graphic.pieceLabels[row][column].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        handleSquareClick(new Position(r, c));
                    }
                });
            }
        }
    }

    private void handleSquareClick(Position position) {
        Player currentPlayer = getCurrentPlayer();
        brique.makeMove(position, currentPlayer);
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
        updateChessboard();
        checkVictory();
    }

    private void restartGame() {
        brique.resetGame();
        graphic.resetChessBoard();
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
    }

    private void quitGame() {
        System.exit(0);
    }

    private Player getCurrentPlayer() {
        return (brique.getTurn() % 2 == 0) ? Player.PLAYER2 : Player.PLAYER1;
    }

    private void updateTurnIndicatorLabel() {
        graphic.turnIndicator.setText("Turn: " + brique.getTurn());
    }

    private void updatePlayerNumberLabel() {
        Player currentPlayer = getCurrentPlayer();
        String playerText;
        if (currentPlayer == Player.PLAYER1) {
            playerText = "PLAYER-1";
        } else {
            playerText = "PLAYER-2";
        }
        graphic.playerNumber.setText("Player: " + playerText);
    }


    private void updateChessboard() {
        for (int row = 0; row < brique.getChessboard().getChessboardDimension(); row++) {
            for (int column = 0; column < brique.getChessboard().getChessboardDimension(); column++) {
                Player player = brique.getChessboard().checkSquarePlayer(new Position(row, column));
                if (player != null) {
                    Icon playerIcon = getPlayerIcon(player);
                    graphic.pieceLabels[row][column].setIcon(playerIcon);
                } else {
                    graphic.pieceLabels[row][column].setIcon(null);
                }
            }
        }
    }

    private Icon getPlayerIcon(Player player) {
        if (player == Player.PLAYER1) {
            return player1Icon;
        } else if (player == Player.PLAYER2) {
            return player2Icon;
        } else {
            return null;
        }
    }

    private void checkVictory() {
        if (brique.isVictory()) {
            Player currentPlayer = getCurrentPlayer();
            String playerText;
            if (currentPlayer == Player.PLAYER1) {
                playerText = "PLAYER-1";
            } else {
                playerText = "PLAYER-2";
            }
            JOptionPane.showMessageDialog(null, playerText + " IS THE WINNER!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void start() {
        SwingUtilities.invokeLater(() -> graphic.frame.setVisible(true));
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
