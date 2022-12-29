package exceptions;

public class DuplicateCharacterException extends RuntimeException{

    public DuplicateCharacterException(Character character){
        System.out.println("symbol "+character+" already exists");
    }
}
