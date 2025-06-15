package strategies;

import java.util.HashMap;

import models.Board;
import models.Move;

public class RowWinningStrategy implements WinningStrategy{
    HashMap<Integer, HashMap<String,Integer>> rowMap = new HashMap<>();
    
    @Override
    public boolean checkWinner(Board board, Move move) {


        String symbol = move.getPlayer().getSymbol();

        int row =move.getCell().getRow();
        
        if(!rowMap.containsKey(row)){
            rowMap.put(row, new HashMap<>());
            rowMap.get(row).put(symbol,1);
        } 
        else {
            if(rowMap.get(row).containsKey(symbol)){
                rowMap.get(row).put(symbol,(rowMap.get(row).get(symbol))+1);
            } else {
                rowMap.get(row).put(symbol, 1);
            }
        }

        if(rowMap.get(row).get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    } 
    
}
