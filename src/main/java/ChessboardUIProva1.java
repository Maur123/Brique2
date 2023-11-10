import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessboardUIProva1 {
    private final Chessboard chessboard;
    private final Brique brique;
    private final JButton[][] squares;

    public ChessboardUIProva1(Chessboard chessboard, Brique brique) {
        this.chessboard = chessboard;
        this.brique = brique;
        squares = new JButton[chessboard.getDIMENSION()][chessboard.getDIMENSION()];
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Brique Chessboard");
        frame.setLayout(new GridLayout(chessboard.getDIMENSION(), chessboard.getDIMENSION()));

        for (int row = 0; row < chessboard.getDIMENSION(); row++) {
            for (int col = 0; col < chessboard.getDIMENSION(); col++) {
                squares[row][col] = new JButton("");
                squares[row][col].setFocusPainted(false);
                squares[row][col].setPreferredSize(new Dimension(60, 60));

                final int finalRow = row;
                final int finalCol = col;

                squares[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Player currentPlayer = brique.getTurn() == 0 ? Player.PLAYER1 : Player.PLAYER2;
                        brique.makeMove(new Posizione(finalRow, finalCol), currentPlayer);
                        updateUI();
                    }
                });

                frame.add(squares[row][col]);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateUI() {
        for (int row = 0; row < chessboard.getDIMENSION(); row++) {
            for (int col = 0; col < chessboard.getDIMENSION(); col++) {
                Player player = chessboard.checkSquarePlayer(new Posizione(row, col));
                squares[row][col].setText(player == Player.PLAYER1 ? "P1" : (player == Player.PLAYER2 ? "P2" : ""));
            }
        }
    }

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(); // Sostituisci con la tua dimensione
        Brique brique = new Brique(chessboard);
        new ChessboardUIProva1(chessboard, brique);
    }
}
