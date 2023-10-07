package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception;

public class FlorNotFoundException extends RuntimeException{

    String msg;
    public FlorNotFoundException(){

    }
    public FlorNotFoundException(String msg){
        super(msg);
    }

}
