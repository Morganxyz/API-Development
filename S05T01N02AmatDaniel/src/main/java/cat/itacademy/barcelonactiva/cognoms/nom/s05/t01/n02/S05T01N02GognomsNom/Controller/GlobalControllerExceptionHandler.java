package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Controller;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNoData;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNoListFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.S05T01N02GognomsNom.Model.Exception.FlorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?>handleFlorNotFound(FlorNotFoundException ex){
    return new ResponseEntity<>("Error P-401", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?>handlerFlorListNotValid(FlorNoListFoundException ex){
        return new ResponseEntity<>("Error P-403", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?>handlerFlorNoData(FlorNoData ex){
        return new ResponseEntity<>("Error P-402", HttpStatus.NO_CONTENT);
    }


}
