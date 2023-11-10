import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessboardUI {
    private final int dimension = 15; // Dimensione della scacchiera (numero di righe/colonne)
    private final JFrame frame;
    private final JPanel[][] squares;
    private int turn;
    private JLabel turnLabel;

    public ChessboardUI() {
        frame = new JFrame("Scacchiera " + dimension + "x" + dimension);
        frame.setLayout(new GridLayout(dimension, dimension)); // +1 per la riga e la colonna dei pulsanti

        squares = new JPanel[dimension][dimension];
        initializeSquares();
        initializeButtons();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int squareSize = 30; // Dimensione desiderata per ciascun quadrato
        int frameSize = dimension * squareSize; // Calcolo delle dimensioni del JFrame
        frame.setSize(frameSize, frameSize); // Imposta le dimensioni del JFrame
        frame.setVisible(true);
    }

    private void initializeSquares() {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                squares[row][col] = new JPanel();
                squares[row][col].setPreferredSize(new Dimension(30, 30)); // Imposta la dimensione desiderata per ciascun quadrato
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(new Color(139, 69, 19)); // Marrone
                } else {
                    squares[row][col].setBackground(new Color(255, 228, 181)); // Crema
                }
                final int finalRow = row;
                final int finalCol = col;

                squares[row][col].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        // Gestisci il clic su una casella qui
                        // Esempio: squares[finalRow][finalCol].setBackground(Color.RED);
                    }
                });

                frame.add(squares[row][col]);
            }
        }
    }

    private void initializeButtons() {
        JButton startButton = new JButton("Inizio");
        startButton.setSize(30,30);
        JButton endButton = new JButton("Fine");
        endButton.setSize(30,30);
        turnLabel = new JLabel("Turno: 0");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gestisci il clic sul pulsante "Inizio" qui
                // Esempio: startGame();
            }
        });

        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gestisci il clic sul pulsante "Fine" qui
                // Esempio: endGame();
            }
        });

        frame.add(startButton);
        frame.add(endButton);
        frame.add(turnLabel);
    }

    public void setTurn(int turn) {
        this.turn = turn;
        turnLabel.setText("Turno: " + turn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChessboardUI();
            }
        });
    }
}
