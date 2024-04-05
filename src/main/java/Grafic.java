import javax.swing.*;
import java.awt.*;

public class Grafic {
    public JFrame frame;
    public JPanel chessPanel;
    public JLabel[][] pieceLabels;
    public JButton restartButton;
    public JButton quitButton;
    public JLabel turnIndicator;
    public JLabel playerNumber;

    public Grafic() {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Creazione della scacchiera
        chessPanel = new JPanel(new GridLayout(15, 15));
        pieceLabels = new JLabel[15][15];
        createChessBoard();

        // Creazione dei bottoni e indicatori
        restartButton = new JButton("Restart");
        quitButton = new JButton("Quit");
        turnIndicator = new JLabel("Turn: 0");
        playerNumber = new JLabel("Player: PLAYER-1");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restartButton);
        buttonPanel.add(quitButton);
        buttonPanel.add(turnIndicator);
        buttonPanel.add(playerNumber);

        frame.add(chessPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private void createChessBoard() {
        for (int row = 0; row < 15; row++) {
            for (int column = 0; column < 15; column++) {
                JPanel squarePanel = new JPanel();
                if (((row + column) % 2) == 0) {
                    squarePanel.setBackground(new Color(139, 69, 19)); // Marrone
                } else {
                    squarePanel.setBackground(new Color(255, 248, 220)); // Crema
                }
                squarePanel.setOpaque(true); // Assicurarsi che il pannello mostri il colore di sfondo
                squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                chessPanel.add(squarePanel);

                JLabel pieceLabel = new JLabel();
                pieceLabel.setSize(50, 50);  // Imposta la dimensione dell'etichetta
                squarePanel.setLayout(new BorderLayout());
                squarePanel.add(pieceLabel, BorderLayout.CENTER);

                pieceLabels[row][column] = pieceLabel;

                chessPanel.add(squarePanel);
            }
        }
    }

    public void resetChessBoard() {
        // Rimuovi tutti i pezzi dalla scacchiera
        for (int row = 0; row < 15; row++) {
            for (int column = 0; column < 15; column++) {
                pieceLabels[row][column].setIcon(null); // Rimuovi l'icona del pezzo
            }
        }
    }
}
