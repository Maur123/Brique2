import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Brique brique;
    private Grafic grafic;

    public Controller() {
        Chessboard chessboard = new Chessboard(15); // Assuming Chessboard constructor exists
        brique = new Brique(chessboard);
        grafic = new Grafic();

        /*grafic.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });*/

        grafic.restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        grafic.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitGame();
            }
        });

        // Aggiungi azioni per le caselle della scacchiera
        for (int row = 0; row < 15; row++) {
            for (int column = 0; column < 15; column++) {
                final int r = row;
                final int c = column;
                grafic.pieceLabels[row][column].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        handleSquareClick(new Posizione(r, c));
                    }
                });
            }
        }
    }

    /*private void startGame() {
        brique.resetGame();
        grafic.resetChessBoard();
        updateTurnIndicator();
    }*/

    private void restartGame() {
        brique.resetGame();
        grafic.resetChessBoard();
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
    }

    private void quitGame() {
        System.exit(0);
    }

    private void handleSquareClick(Posizione posizione) {
        Player currentPlayer = getCurrentPlayer();
        brique.makeMove(posizione, currentPlayer);
        updateTurnIndicatorLabel();
        updatePlayerNumberLabel();
        updateChessboard();
        checkVictory();
    }

    private Player getCurrentPlayer() {
        return (brique.getTurn() % 2 == 0) ? Player.PLAYER2 : Player.PLAYER1;
    }

//    private void updateChessboard2() {
//        // Aggiorna la scacchiera sulla GUI in base alla disposizione delle pedine
//        for (int row = 0; row < 15; row++) {
//            for (int column = 0; column < 15; column++) {
//                Player player = brique.getChessboard().getSquarePlayer(new Posizione(row, column));
//                if (player != null) {
//                    // Aggiorna la GUI con la pedina del giocatore corrispondente
//                    // Ad esempio: grafic.pieceLabels[row][column].setIcon(new ImageIcon(player.getPieceIcon()));
//                }
//            }
//        }
//    }

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
        // Aggiorna la scacchiera sulla GUI in base alla disposizione delle pedine
        for (int row = 0; row < brique.getChessboard().getChessboardDimension(); row++) {
            for (int column = 0; column < brique.getChessboard().getChessboardDimension(); column++) {
                Player player = brique.getChessboard().checkSquarePlayer(new Posizione(row, column));
                if (player != null) {
                    // Ottieni l'icona associata al giocatore
                    ImageIcon playerIcon = getPlayerIcon(player);
                    // Aggiorna la GUI con l'icona del giocatore sulla casella corrispondente
                    grafic.pieceLabels[row][column].setIcon(playerIcon);
                } else {
                    // Se non c'è nessun giocatore sulla casella, rimuovi l'icona
                    grafic.pieceLabels[row][column].setIcon(null);
                }
            }
        }
    }

    // Metodo per ottenere l'icona associata al giocatore
    private ImageIcon getPlayerIcon(Player player) {
        // Supponiamo che ogni giocatore abbia un'icona associata alla sua pedina
        // Esempio di implementazione:
        if (player == Player.PLAYER1) {
            return new ImageIcon(getClass().getResource("/pedinarossa.png"));
//            return new ImageIcon("path_to_player1_icon.png");
//            pieceLabel.setIcon(new ImageIcon(getClass().getResource("/pedinarossa.png")));
        } else if (player == Player.PLAYER2) {
            return new ImageIcon(getClass().getResource("/pedinanera.png"));
            //return new ImageIcon("path_to_player2_icon.png");
        } else {
            // Se non è possibile determinare l'icona, restituisci null
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                grafic.frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
