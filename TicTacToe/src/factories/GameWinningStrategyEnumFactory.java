package factories;

import models.GameWinningStrategyEnum;

public class GameWinningStrategyEnumFactory {

    public static GameWinningStrategyEnum getGameWinningStrategyEnumByName(String name){
//      return  switch(name) {
//            case "row" -> GameWinningStrategyEnum.ROW;
//            case "column" -> GameWinningStrategyEnum.COLUMN;
//            case "diagonal" -> GameWinningStrategyEnum.DIAGONAL;
//            case "corner" -> GameWinningStrategyEnum.CORNER;
//        };
      return GameWinningStrategyEnum.ROW;
    }
}
