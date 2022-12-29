package models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;

    private PlayerType playerType;

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row ");
        int row = sc.nextInt();
        System.out.println(("Enter the col"));
        int col = sc.nextInt();
        Move move = new Move(row, col, this);
        return move;
    }
}
