public class Square {
    private Color color;
    private Player player;

    public Square(Color color) {
        this.color = color;
    }

    public boolean isFree() {
        return (player == null);
    }

    public void occupy(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Color getColor() {
        return color;
    }
}
