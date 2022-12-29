package factories;

import models.*;

public class PlayerFactor {

    public static Player createHumanPlayer(String name, Character character){
        Player player = new Player();
        player.setName(name);
        player.setPlayerType(PlayerType.HUMAN);
        player.setSymbol(new Symbol(character));
        return player;
    }

    public static Player createBotPlayer(String name, Character character){
        Bot bot = new Bot();
        bot.setName(name);
        bot.setPlayerType(PlayerType.BOT);
        bot.setSymbol(new Symbol(character));
        bot.setBotDifficultyLevel(BotDifficultyLevel.EASY);
        return null;
    }
}
