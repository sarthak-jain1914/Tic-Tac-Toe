package models;
public class Cell {
    private int row;
    private int col;
    private CellState state;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state = CellState.EMPTY;
        this.player = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }   

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void displayCell() {
        if (player == null) {
            System.out.print("| - |");
        } else {
            System.out.printf("| " + player.getSymbol()  + " |");
        }
    }
}
