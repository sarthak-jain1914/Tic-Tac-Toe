package strategies;

import java.util.HashMap;

import models.Board;
import models.Move;

public class ColWinningStrategy implements WinningStrategy{
    HashMap<Integer, HashMap<String,Integer>> colMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {


        String symbol = move.getPlayer().getSymbol();

        int col =move.getCell().getCol();
        
        if(!colMap.containsKey(col)){
            // rowMap.put(row, (HashMap<String, Integer>) new HashMap<>().put(symbol, 1));
            colMap.put(col, new HashMap<>());
            colMap.get(col).put(symbol,1);
        } else {
            if(colMap.get(col).containsKey(symbol)){
                colMap.get(col).put(symbol,(colMap.get(col).get(symbol))+1);
            } else {
                colMap.get(col).put(symbol, 1);
            }
        }

        if(colMap.get(col).get(symbol) == board.getDimension()){
            System.out.println("Player " + move.getPlayer().getName() + " wins by column!");
            return true;
        }
        return false;
    }
    
}
