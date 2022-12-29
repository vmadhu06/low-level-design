import factories.GameWinningStrategyEnumFactory;
import factories.PlayerFactor;
import models.Game;
import models.GameStatus;
import models.GameWinningStrategyEnum;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Number of players ");
        Scanner sc = new Scanner(System.in);
        int noOfPlayers = sc.nextInt();
        System.out.println("Number of bots");
        int noOfBots = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<noOfBots; i++){
            System.out.println("name of bot "+(i+1));
          String name =  sc.next();
            System.out.println("Symbol of bot "+(i+1));
          Character character = sc.next().charAt(0);
            System.out.println("difficulty of bot "+(i+1));
          String difficulty = sc.next();
          players.add(PlayerFactor.createBotPlayer(name, character));
        }
        for(int i=noOfBots; i<noOfPlayers; i++){
            System.out.println("name of Player "+(i-noOfBots+1));
            String name = sc.next();
            System.out.println("Symbol of Player "+(i-noOfBots+1));
            Character character = sc.next().charAt(0);
            players.add(PlayerFactor.createHumanPlayer(name, character));
        }
        System.out.println("Number of game winning startegies ");
        Integer noOfWinningStrategies = sc.nextInt();
        List<GameWinningStrategyEnum> gameWinningStrategies = new ArrayList<>();
        for(int i=0; i<noOfWinningStrategies; i++){
            System.out.println("name of winningStrategy is ");
            String winningStrategyName = sc.next();
            gameWinningStrategies.add(GameWinningStrategyEnumFactory.getGameWinningStrategyEnumByName(winningStrategyName));
        }

        Game game = Game.getBuilder()
                .setPlayers(players)
                .setGameWinningStrategies(gameWinningStrategies)
                .build();
        while(game.getGameStatus().equals(GameStatus.INPROGRESS)){
            game.makeMove();
        }


    }
}