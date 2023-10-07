package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception;

public class FlorNoListFoundException extends RuntimeException{

    String msg;
    public FlorNoListFoundException(){

    }
    public FlorNoListFoundException(String msg){
        super(msg);
    }
}
