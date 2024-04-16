import javax.swing.*;
import java.awt.*;

public class Graphic {
    public JFrame frame;
    public JPanel chessPanel;
    public JLabel[][] pieceLabels;
    public JButton restartButton;
    public JButton quitButton;
    public JLabel turnIndicator;
    public JLabel playerNumber;
    private final Color BROWN = new Color(139, 69, 19);
    private final Color CREAM = new Color(255, 248, 220);
    private final int chessboardSize;

    public Graphic(int chessboardSize) {
        this.chessboardSize = chessboardSize;

        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        chessPanel = new JPanel(new GridLayout(chessboardSize, chessboardSize));
        pieceLabels = new JLabel[chessboardSize][chessboardSize];
        createChessBoard();

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
        for (int row = 0; row < chessboardSize; row++) {
            for (int column = 0; column < chessboardSize; column++) {
                JPanel squarePanel = new JPanel();
                if (((row + column) % 2) == 0) {
                    squarePanel.setBackground(BROWN);
                } else {
                    squarePanel.setBackground(CREAM);
                }
                squarePanel.setOpaque(true);
                squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                chessPanel.add(squarePanel);

                JLabel pieceLabel = new JLabel();
                pieceLabel.setSize(50, 50);
                squarePanel.setLayout(new BorderLayout());
                squarePanel.add(pieceLabel, BorderLayout.CENTER);

                pieceLabels[row][column] = pieceLabel;

                chessPanel.add(squarePanel);
            }
        }
    }

    public void resetChessBoard() {
        for (int row = 0; row < chessboardSize; row++) {
            for (int column = 0; column < chessboardSize; column++) {
                pieceLabels[row][column].setIcon(null);
            }
        }
    }
}
