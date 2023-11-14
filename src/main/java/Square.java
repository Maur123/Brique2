public class Square {
    private ColorSquare colorSquare;
    private Player player;

    public Square(ColorSquare colorSquare) {
        this.colorSquare = colorSquare;
    }

    public boolean isFree() {
        return (player == null);
    }

    public void occupy(Player player) {
        this.player = player;
    }

    //da testare...
    public void makePlayerNull() {
        this.player = null;
    }

    public Player getPlayer() {
        return player;
    }

    public ColorSquare getColor() {
        return colorSquare;
    }
}
