package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Controller;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Dto.SucursalDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Entity.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<Sucursal> add(@RequestBody Sucursal sucursal) {

        try {
            return new ResponseEntity<>(sucursalService.crearSucursal(sucursal), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")

    public ResponseEntity<SucursalDto> getOne(@PathVariable(name = "id") Integer id) {

        SucursalDto sucursalDto = sucursalService.veureUnaSucursal(id);

        if (sucursalDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(sucursalDto, HttpStatus.OK);
        }
    }
    @GetMapping({"/getAll"})
    public List<SucursalDto>getAll() {

        List<SucursalDto>sucursalDtoList = sucursalService.veureTotesSucursals();;

        return sucursalDtoList;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sucursal> delete(@PathVariable(name = "id") Integer id) {

        try {
            Sucursal sucursalEliminada = sucursalService.eliminarSucursal(id);

            if (sucursalEliminada != null) {
                return new ResponseEntity<>(sucursalEliminada, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")

    public Sucursal update(@PathVariable(name = "id") Integer id, @RequestBody Sucursal sucursal) {

           Sucursal sucursalMod =  sucursalService.modificarSucursal(id,sucursal);

         return sucursalMod;
    }
}

