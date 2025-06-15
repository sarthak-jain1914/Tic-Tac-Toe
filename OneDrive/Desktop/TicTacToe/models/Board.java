package models;
import java.util.ArrayList;
import java.util.List;

public class Board {
    int demention;
    List<List<Cell>> board;

    public Board(int demention) {
        this.demention = demention;
        this.board = new ArrayList<>();
        for(int i = 0; i < demention;i++){
            ArrayList<Cell> row = new ArrayList<>();
            for(int j = 0; j < demention;j++){
                row.add(new Cell(i,j));
            }
            this.board.add(row);
        }
    }

    public int getDimension() {
        return this.demention;
    }

    public void setdimention(int demention){
        this.demention = demention;
    }

    public List<List<Cell>> getBoard(){
        return board;
    }

    public void setBoard(List<List<Cell>> board){
        this.board = board;
    }

    public void printBoard(){
        for(List<Cell> row: board){
            for(Cell c:row){
                c.displayCell();
            }
            System.out.println();
        }
    }

}
