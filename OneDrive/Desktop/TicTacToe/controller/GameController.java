package controller;

import java.util.List;
import models.Game;
import models.GameState;
import models.Player;
import strategies.WinningStrategy;

public class GameController {

    public Game startGame(int demention, List<Player> players, List<WinningStrategy> WinningStrategy) {

        return new Game.GameBuilder()
            .setBoard(demention)
            .setListOfPlayers(players)
            .setListWinningStrategy(WinningStrategy)
            .build();
    }

    public void printBoard(Game game)   {
        game.printBoard();
    }

    // make move 
    // undoo
    // state

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undoMove(Game game) {
        
    }

    public GameState getGameState(Game game) {
        return game.getState();
    }
}
