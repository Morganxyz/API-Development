package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception;

public class FlorNoData extends RuntimeException{

    String msg;
    public FlorNoData(){

    }
    public FlorNoData(String msg){
        super(msg);
    }

}

