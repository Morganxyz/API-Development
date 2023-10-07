package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Controller;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Dto.SucursalDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Entity.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.S05T01N01GognomsNom.Model.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SucursalWebController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping({"","/"})
    public String showListView(Model modelo){

        List<SucursalDto> sucursalDtoList = sucursalService.veureTotesSucursals();;
        modelo.addAttribute("sucursalDtoList",sucursalDtoList);

        return "listado";
    }
    @GetMapping("/novaSucursal")
    public String showCreateView(Model modelo){
        Sucursal sucursal = new Sucursal();
        modelo.addAttribute("sucursal",sucursal);

        return "novaSucursalFormulari";
    }
    @GetMapping("/edit/{id}")
    public String showEditView(Model modelo,@PathVariable int id){

        SucursalDto sucursalDto = sucursalService.veureUnaSucursal(id);
        modelo.addAttribute("sucursal",sucursalDto);

        return "modificarSucursalFormulari";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        sucursalService.eliminarSucursal(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Sucursal sucursal){
        sucursalService.crearSucursal(sucursal);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.modificarSucursal(id,sucursal);
        return "redirect:/";
    }
}

