import javax.swing.*;
import java.util.Objects;

public class Controller {
    private final Brique brique;
    private final Grafic grafic;

    public Controller() {
        Chessboard chessboard = new Chessboard(15);
        brique = new Brique(chessboard);
        grafic = new Grafic();

        grafic.restartButton.addActionListener(e -> restartGame());

        grafic.quitButton.addActionListener(e -> quitGame());

        for (int row = 0; row < 15; row++) {
            for (int column = 0; column < 15; column++) {
                final int r = row;
                final int c = column;
                grafic.pieceLabels[row][column].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        handleSquareClick(new Position(r, c));
                    }
                });
            }
        }
    }

    private void restartGame() {
        brique.resetGame();
        grafic.resetChessBoard();
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
    }

    private void quitGame() {
        System.exit(0);
    }

    private void handleSquareClick(Position position) {
        Player currentPlayer = getCurrentPlayer();
        brique.makeMove(position, currentPlayer);
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
        updateChessboard();
        checkVictory();
    }

    private Player getCurrentPlayer() {
        return (brique.getTurn() % 2 == 0) ? Player.PLAYER2 : Player.PLAYER1;
    }

    private void updateTurnIndicatorLabel() {
        grafic.turnIndicator.setText("Turn: " + brique.getTurn());
    }

    private void updatePlayerNumberLabel() {
        Player currentPlayer = getCurrentPlayer();
        String playerText;
        if (currentPlayer == Player.PLAYER1) {
            playerText = "PLAYER-1";
        } else {
            playerText = "PLAYER-2";
        }
        grafic.playerNumber.setText("Player: " + playerText);
    }


    private void updateChessboard() {
        for (int row = 0; row < brique.getChessboard().getChessboardDimension(); row++) {
            for (int column = 0; column < brique.getChessboard().getChessboardDimension(); column++) {
                Player player = brique.getChessboard().checkSquarePlayer(new Position(row, column));
                if (player != null) {
                    ImageIcon playerIcon = getPlayerIcon(player);
                    grafic.pieceLabels[row][column].setIcon(playerIcon);
                } else {
                    grafic.pieceLabels[row][column].setIcon(null);
                }
            }
        }
    }

    private ImageIcon getPlayerIcon(Player player) {
        if (player == Player.PLAYER1) {
            return new ImageIcon(Objects.requireNonNull(getClass().getResource("/pedinarossa.png")));
        } else if (player == Player.PLAYER2) {
            return new ImageIcon(Objects.requireNonNull(getClass().getResource("/pedinanera.png")));
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
            JOptionPane.showMessageDialog(null, playerText+" IS THE WINNER!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void start() {
        SwingUtilities.invokeLater(() -> grafic.frame.setVisible(true));
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
