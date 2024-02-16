/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Grafic grafic;
    private Brique brique;
    private Chessboard chessboard;

    public Controller(Grafic grafic, Brique brique, Chessboard chessboard) {
        this.grafic = grafic;
        this.brique = brique;
        this.chessboard = chessboard;

        grafic.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brique.resetGame();
                grafic.restChessBoard();
                System.out.println("Inizia il gioco!");
            }
        });

        grafic.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fine del gioco!");
                grafic.frame.dispose(); // Chiude la finestra
                System.exit(0); // Termina l'applicazione
            }
        });

        for (Component component : grafic.chessPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                panel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        // Ottieni la posizione del pannello cliccato
                        int row = panel.getY() / panel.getHeight();
                        int col = panel.getX() / panel.getWidth();
                        System.out.println("Hai cliccato sulla casella: " + row + ", " + col);

                        // Chiamata al metodo makeMove di Brique
                        if(brique.getTurn() % 2 == 1) {

                            brique.makeMove(new Posizione(row, col), Player.PLAYER1);

                            //controllo tutte le caselle e le aggiorno
                            checkAndUpdateBoardGraphics();

                            if(brique.checkVictoryPlayer(Player.PLAYER1)){
                                JOptionPane.showConfirmDialog(grafic.frame, "PLAYER-1 WINS!!!", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                int result = JOptionPane.showConfirmDialog(grafic.frame, "PLAYER-1 WINS!!!", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                if (result == JOptionPane.OK_OPTION) {
                                    // Azione da eseguire quando l'utente clicca "OK"
                                    System.out.println("L'utente ha cliccato su OK");
                                    brique.resetGame();
                                    grafic.restChessBoard();
                                }
                                System.out.println("Finisce il gioco!");
                            }
                        }
                        else{

                            brique.makeMove(new Posizione(row, col), Player.PLAYER2);

                            //controllo tutte le caselle e le aggiorno
                            checkAndUpdateBoardGraphics();

                            if(brique.checkVictoryPlayer(Player.PLAYER2)){
                                JOptionPane.showConfirmDialog(grafic.frame, "PLAYER-2 WINS!!!", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                int result = JOptionPane.showConfirmDialog(grafic.frame, "PLAYER-2 WINS!!!", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                if (result == JOptionPane.OK_OPTION) {
                                    // Azione da eseguire quando l'utente clicca "OK"
                                    System.out.println("L'utente ha cliccato su OK");
                                    brique.resetGame();
                                    grafic.restChessBoard();
                                }
                                System.out.println("Finisce il gioco!");
                            }
                        }

                        grafic.turnIndicator.setText("Turn: " + brique.getTurn());

                        //update Label PlayerNumber
                        if(brique.getTurn() % 2 == 1) {
                            grafic.playerNumber.setText("Player: PLAYER-2");
                        }
                        else{
                            grafic.playerNumber.setText("Player: PLAYER-1");
                        }
                    }
                });
            }
        }

    }

    private void checkAndUpdateBoardGraphics() {
        for (int row = 0; row < chessboard.getChessboardDimension(); row++) {
            for (int col = 0; col < chessboard.getChessboardDimension(); col++) {
                Player player = chessboard.checkSquarePlayer(new Posizione(row, col));
                JPanel squarePanel = (JPanel) grafic.chessPanel.getComponent(row * chessboard.getChessboardDimension() + col);
                JLabel pieceLabel = grafic.pieceLabels[row][col];

if (player == Player.PLAYER1) {
                    squarePanel.setBackground(Color.BLACK);
                } else if (player == Player.PLAYER2) {
                    squarePanel.setBackground(Color.RED);
                }


                if (player == Player.PLAYER1) {
                    //squarePanel.setBackground(Color.BLACK);
                    pieceLabel.setIcon(new ImageIcon(getClass().getResource("/pedinarossa.png")));
                } else if (player == Player.PLAYER2) {
                    //squarePanel.setBackground(Color.RED);
                    pieceLabel.setIcon(new ImageIcon(getClass().getResource("/pedinanera.png")));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Grafic grafic = new Grafic();
            Chessboard chessboard = new Chessboard();
            Brique brique = new Brique(chessboard);
            Controller controller = new Controller(grafic, brique, chessboard);
        });
    }
}
*/
