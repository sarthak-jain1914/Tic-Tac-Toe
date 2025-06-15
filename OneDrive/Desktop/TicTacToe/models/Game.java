package models;
import java.util.ArrayList;
import java.util.List;

import strategies.WinningStrategy;



public class Game{
    private List<Player> players;
    private List<Move> moves;
    private GameState state;
    private int currentPlayerIndex;
    private Board board;
    private Player winner;
    private List<WinningStrategy> listWinningStrategy;

    Game(GameBuilder builder){
        this.players = builder.players;
        this.board = builder.board;
        this.listWinningStrategy = builder.listWinningStrategy;
        this.state = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
    }

    public static class GameBuilder{
        private List<Player> players;
        private Board board;
        private List<WinningStrategy> listWinningStrategy;

        public GameBuilder setListOfPlayers (List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setBoard (int demention) {
            this.board = new Board(demention);
            return this;
        }

        public GameBuilder setListWinningStrategy(List<WinningStrategy> listWinningStrategy) {
            this.listWinningStrategy = listWinningStrategy;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(int demention ) {
        this.board = new Board(demention);
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getListWinningStrategy() {
        return listWinningStrategy;
    }

    // printing the board
    public void printBoard(){
        board.printBoard();
    }

    //making move

    public void makeMove(){

        Player player = players.get(currentPlayerIndex);
        
        Move newMove = player.makeMove(board);

        // while(!validateMove(player.makeMove(board)))
        // {
        //    newMove = player.makeMove(board);
        // }
        
        List<List<Cell>> currBoard = board.getBoard();

        int row = newMove.getCell().getRow();
        int col = newMove.getCell().getCol();

        Cell currCell = currBoard.get(row).get(col);
        Cell c = new Cell(row, col);
        c.setPlayer(player);
        c.setState(CellState.BLOCKED);
        currBoard.get(row).set(col, c);

        Move anotherMove = new Move(player,currCell);
        moves.add(anotherMove);

        if(checkWinner(board, newMove)){
            state = GameState.END;
            winner = player;
            System.out.println("Player " + player.getName() + " wins!");
        } else if(moves.size() == board.getBoard().size()*board.getBoard().size()){
            state = GameState.DRAW;
            System.out.println("Game is draw");
        } 
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private boolean validateMove(Move move) {
        //if cell is out of bounds
        if(move.getCell().getRow() < 0 || move.getCell().getRow() <= board.getBoard().size() ||
           move.getCell().getCol() < 0 || move.getCell().getCol() <= board.getBoard().size()){
            System.out.println("Invalid move. Cell is out of bounds");
            return false;
        }
        //if cell is blocked
        else if(move.getCell().getState().equals(CellState.BLOCKED)){
            System.out.println("Cell is already blocked");
            return false;
        }
        return true;
    }

    private boolean checkWinner(Board board2, Move move) {
        for(WinningStrategy wStrategy : listWinningStrategy){
            if(wStrategy.checkWinner(board2, move)){
                System.out.println("we are in" + wStrategy.getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }
}





        // Player currentPlayer = players.get(currentPlayerIndex);
        // Move currMove = currentPlayer.makeMove(board);

        // // if(!validateMove(move)){
        // //     System.out.println("Invalid move. Try again.");
        // //     return;
        // // }
        // int currRow = currMove.getCell().getRow();
        // int currCol = currMove.getCell().getCol();

        // // Cell currCell = board.getBoard().get(currRow).get(currCol);
        // Cell currCell = currMove.getCell();

        // board.getBoard().get(currRow).get(currCol).setState(CellState.BLOCKED);
        // board.getBoard().get(currRow).get(currCol).setPlayer(currentPlayer);
        // // currCell.setState(CellState.BLOCKED);
        // // currCell.setPlayer(currentPlayer);

        // Move newMove = new Move(currentPlayer, currCell);
        // moves.add(newMove);
        // System.out.println("Player " + currentPlayer.getName() + " made move at cell (" + newMove.cell.getRow() + "," + newMove.cell.getCol() + ")");
            
        // if(checkWinner(board,newMove)){
        //     System.out.println("we are in checkWinner function");
        //     this.state = GameState.END;
        //     this.winner= currentPlayer;
        // } else if(moves.size() == this.getBoard().getBoard().size()* this.getBoard().getBoard().size()){
        //     System.out.println("we are in else checkWinner function");
        //     state = GameState.DRAW;
        // }
        // System.out.println("outside  checkWinner function");
        // currentPlayerIndex = (currentPlayerIndex+1) % players.size();