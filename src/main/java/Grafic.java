import javax.swing.*;
import java.awt.*;

public class ChessBoardGUI {
    private JFrame frame;
    private JPanel chessPanel;
    private JButton startButton;
    private JButton endButton;
    private JLabel turnIndicator;
    private JLabel playerNumber;

    public ChessBoardGUI() {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Creazione della scacchiera
        chessPanel = new JPanel(new GridLayout(15, 15));
        createChessBoard();

        // Creazione dei bottoni e indicatori
        startButton = new JButton("Inizia");
        endButton = new JButton("Termina");
        turnIndicator = new JLabel("Turno: ");
        playerNumber = new JLabel("Giocatore: ");

        JPanel buttonPanel = new JPanel();
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
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                JPanel panel = new JPanel();
                //panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                chessPanel.add(panel);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessBoardGUI());
    }
}
