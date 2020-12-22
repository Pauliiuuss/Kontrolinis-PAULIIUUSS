package lt2020.sveikinimai.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sveikinimai.entities.SveikinimoVieta;
import lt2020.sveikinimai.services.SveikinimoVietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api("sveikinimoVieta")
@RequestMapping("/sveikinimoVietos")
public class SveikinimoVietosController {

    @Autowired
    public SveikinimoVietaService sveikinimoVietaService;

    @GetMapping
    @ApiOperation(value="Gauti sveikinimo vietas",notes="Grazina sveikinimo vietu sarasa")
    public Collection<SveikinimoVieta> gautiSveikinimoVietas() {
        return sveikinimoVietaService.gautiSveikinimoVietas();
    }

    @DeleteMapping("{sveikinimoVietosId}")
    @ApiOperation(value="Istrinti sveikinimo vieta",notes="Istrina sveikinimo vietas")
    public void istrintiSveikinimoVieta(@PathVariable("sveikinimoVietosId") int id){
        sveikinimoVietaService.istrintiSveikinimoVieta(id);
    }

    @PostMapping("/pridetiSveikinimoVieta")
    @ApiOperation(value="Prideti sveikinimo vieta",notes="Prideda sveikinimo vieta")
    public void pridetiSveikinimoVieta(@RequestBody SveikinimoVieta sveikinimoVieta){
        sveikinimoVietaService.pridetiSveikinimoVieta(sveikinimoVieta);
    }

    @PutMapping("/atnaujintiSveikinimoVieta")
    @ApiOperation(value="Atnaujinti sveikinimo vieta",notes="Atnaujina sveikinimo vieta")
    public void atnaujintiSveikinimoVieta(@RequestBody SveikinimoVieta sveikinimoVieta){
            sveikinimoVietaService.atnaujintiSveikinimoVieta(sveikinimoVieta);
    }
}
