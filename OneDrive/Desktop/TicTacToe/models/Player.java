package models;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private PlayerType type;
    private String symbol; 
       
    private Scanner scanner = new Scanner(System.in);

    public Player(Long id, String name, PlayerType type, String symbol) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(Board board ) {
        System.out.println("Player " + this.name + " (" + this.symbol + "), it's your turn.");

        System.out.println("Enter the row (0-indexed): ");
        int row = scanner.nextInt();
        
        System.out.println("Enter the column (0-indexed): ");
        int col = scanner.nextInt();

        return new Move(this,new Cell(row,col));

    }

}
