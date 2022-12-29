package models;

import exceptions.DuplicateCharacterException;
import factories.GameWinningStrategyFactory;
import strategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players;

    private Board board;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastPlayerIndex;
    private GameStatus gameStatus;
    private List<Move> moves;

    private Player winner;

    int filledCells ;

    private Game(){

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        this.gameWinningStrategies = gameWinningStrategies;
    }

    public int getLastPlayerIndex() {
        return lastPlayerIndex;
    }

    public void setLastPlayerIndex(int lastPlayerIndex) {
        this.lastPlayerIndex = lastPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class Builder{
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Builder setGameWinningStrategies(List<GameWinningStrategyEnum> gameWinningStrategiesEnums) {
            gameWinningStrategies = new ArrayList<>();
            for(GameWinningStrategyEnum gameWinningStrategyEnum : gameWinningStrategiesEnums){
                gameWinningStrategies.add(GameWinningStrategyFactory.getGamewinningStrategyByName(gameWinningStrategyEnum));
            }
            return this;
        }

        public Game build(){
            Set<Character> alreadyExistingCharacters = new HashSet<>();
            for(Player player : players){
                if(alreadyExistingCharacters.contains(player.getSymbol().getCharacter())){
                    throw new DuplicateCharacterException(player.getSymbol().getCharacter());
                }
                alreadyExistingCharacters.add(player.getSymbol().getCharacter());

            }
            Game game = new Game();
            game.players = players;
            game.gameStatus = GameStatus.INPROGRESS;
            game.gameWinningStrategies = gameWinningStrategies;
            game.lastPlayerIndex = -1;
            game.moves = new ArrayList<>();
            game.board = new Board(this.players.size()+1);
            return game;
        }


    }
    public void makeMove(){
        board.display();
        this.lastPlayerIndex+=1;
        this.lastPlayerIndex%=players.size();
        System.out.println(this.players.get(lastPlayerIndex).getName()+" 's turn");
        Move potentialMove = this.players.get(lastPlayerIndex).makeMove();
        Cell cell = board.getCell(potentialMove.getRow(), potentialMove.getCol());
        if(cell.getPlayer() != null){
                    System.out.println("bad move, try again");
                    return;
                }

        filledCells+=1;
        moves.add(new Move(potentialMove.getRow(), potentialMove.getCol(), potentialMove.getPlayer()));
        board.getCell(potentialMove.getRow(), potentialMove.getCol()).setPlayer(players.get(this.lastPlayerIndex));
        if(filledCells == (players.size()+1)*(players.size()+1)){
            gameStatus = GameStatus.DRAW;
            System.out.println("game was drawn");
        }
    }
}
