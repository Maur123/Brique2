import javax.swing.*;
import java.awt.*;

public class Grafic {
    public JFrame frame;
    public JPanel chessPanel;
    public JButton startButton;
    public JButton endButton;
    public JButton winEvent;
    public JLabel turnIndicator;
    public JLabel playerNumber;

    public Grafic() {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Creazione della scacchiera
        chessPanel = new JPanel(new GridLayout(15, 15));
        createChessBoard();

        // Creazione dei bottoni e indicatori
        winEvent = new JButton("winEvent");
        startButton = new JButton("Inizia");
        endButton = new JButton("Termina");
        turnIndicator = new JLabel("Turno: ");
        playerNumber = new JLabel("Giocatore: ");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(winEvent);
        buttonPanel.add(startButton);
        buttonPanel.add(endButton);
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
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Grafic());
    }
}
