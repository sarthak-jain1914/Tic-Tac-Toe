import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.GameController;
import models.Game;
import models.GameState;
import models.Player;
import models.PlayerType;
import strategies.ColWinningStrategy;
import strategies.DiagonalWinningStrategy;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

public class Main {
    public static void main(String args[]) {
        try{
            int demention = 0;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to Tic Tac Toe");
            System.out.println("Make sure to enter a number greater than 2 and less than 10 for demention ");
            System.out.println("Player name set as default and symbols are set as x and o");
            System.out.println("Player1 has symbol X and Player2 has symbol O");
            System.out.println("Enter the dimension of the board: ");
            
            demention = scanner.nextInt();
            
            while(demention < 3 && demention > 10){
                System.out.println("Invalid input");
                System.out.println("Please enter a number greater than 2 and less than 10");
                System.out.println("Enter the dimension of the board: ");
                demention = scanner.nextInt();
            }
            String nameOfPlayer1 = "player1";

            String nameOfPlayer2 = "player2";

            String symbolOfPlayer1 = "x";

            String symbolOfPlayer2 = "0";


            
            

            Player player1 = new Player(1L,nameOfPlayer1, PlayerType.HUMAN, symbolOfPlayer1);
            Player player2 = new Player(2L,nameOfPlayer2, PlayerType.HUMAN, symbolOfPlayer2);


            GameController gameController = new GameController();


            
            List<Player> players = List.of(player1, player2);

            List<WinningStrategy> winningStrategy = new ArrayList<>();

            winningStrategy.add(new RowWinningStrategy());
            winningStrategy.add(new ColWinningStrategy());
            winningStrategy.add(new DiagonalWinningStrategy());

            Game game = gameController.startGame(demention, players, winningStrategy);

            // gameController.printBoard(game);


            //Game Started
            while(game.getState().equals(GameState.IN_PROGRESS) ){

                gameController.printBoard(game);

                System.out.println("------------------------------");
                gameController.makeMove(game);
            }


            gameController.printBoard(game);

            if(game.getState().equals(GameState.END)){
                System.out.println("----------<< Hurry!!! Game is over >>---------- ");
                System.out.println("Player " + game.getWinner().getName() + " wins the game");
            } else {
                System.out.println("Game is draw");
            }


        }catch(Exception e){
            System.out.println("Invalid input" + e.getMessage());
        }
    }
}
