package factories;

import models.GameWinningStrategyEnum;
import strategies.*;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGamewinningStrategyByName(GameWinningStrategyEnum name){
        return switch(name){
            case ROW -> new RowWinningStrategy();
            case COLUMN -> new ColumnWinningStarategy();
            case DIAGONAL -> new DiagonalWinningStrategy();
            case CORNER -> new CornerWinningStrategy();
        };

    }
}
