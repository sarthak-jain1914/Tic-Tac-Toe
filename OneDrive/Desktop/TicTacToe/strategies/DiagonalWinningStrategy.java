package strategies;

import models.Board;
import models.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    
    @Override
    public boolean checkWinner(Board board, Move move) {
        int numberOfSymbols = 0;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        String symbol = move.getPlayer().getSymbol();

        if(row == col){
            //checking for the diagonal from top left to bottom right
            for(int i = 0; i < board.getDimension();i++){
                if(board.getBoard().get(i).get(i).getPlayer() != null &&
                board.getBoard().get(i).get(i).getPlayer().getSymbol().equals(symbol)){
                    numberOfSymbols++;
                }
                else{
                    return false;
                }
            }
            //checking for the diagonal from top right to bottom left
        } else if(row + col == board.getDimension()-1){
            int colIdx = board.getDimension()-1;
            int rowIdx = 0;
            while(colIdx >= 0 && rowIdx < board.getDimension()){
                if(board.getBoard().get(rowIdx).get(colIdx).getPlayer() != null &&
                    board.getBoard().get(rowIdx).get(colIdx).getPlayer().getSymbol().equals(symbol)){
                    numberOfSymbols++;
                }
                else{
                    return false;
                }
                colIdx--;
                rowIdx++;
            }
        }

        if(numberOfSymbols == board.getDimension()){
            System.out.println("Player " + move.getPlayer().getName() + " wins by diagonal!");
            return true;
        }
        return false;
    }
    
    
}
