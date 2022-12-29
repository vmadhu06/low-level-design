package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension){
        this.dimension =dimension;
        board = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            board.add(new ArrayList<>());
            for(int j=0; j<dimension; j++){
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Cell getCell(int row, int col){
        return board.get(row).get(col);
    }

    public void display(){
        for(List<Cell> cells :board){
            for(Cell cell : cells){
                if(cell.getPlayer() == null){
                    System.out.print(" - ");
                }
                else{
                    System.out.print(" "+cell.getPlayer().getSymbol().getCharacter()+" ");
                }
            }
            System.out.println();
        }
    }
}
