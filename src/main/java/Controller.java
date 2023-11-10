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

        grafic.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Avvia il gioco Brique
                System.out.println("Inizia il gioco!");
                // Implementa qui la logica per iniziare il gioco Brique
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
                        brique.makeMove(new Posizione(row, col), Player.PLAYER2);
                    }
                });
            }
        }

        grafic.winEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(grafic.frame, "Vince qualcuno!");
                System.out.println("Finisce il gioco!");

            }
        });

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
