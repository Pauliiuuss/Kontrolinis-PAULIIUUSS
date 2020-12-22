package lt2020.sveikinimai.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sveikinimai.entities.Sveikinimas;
import lt2020.sveikinimai.entities.SveikinimoVieta;
import lt2020.sveikinimai.services.SveikinimasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api("sveikinimas")
@RequestMapping("/sveikinimai")
public class SveikinimasController {

    @Autowired
    public SveikinimasService sveikinimasService;

    @GetMapping
    @ApiOperation(value="Gauti sveikinimus",notes="Grazina sveikinimu sarasa")
    public Collection<Sveikinimas> gautiSveikinimus(){
        return sveikinimasService.gautiSveikinimus();
    }

    @DeleteMapping("{sveikinimoId}")
    @ApiOperation(value="Istrinti sveikinima",notes="Istrina sveikinima pagal id")
    public void istrintiSveikinima( @PathVariable("sveikinimoId") int id){
        sveikinimasService.istrintiSveikinima(id);
    }

    @PostMapping("/pridetiVieta")
    @ApiOperation(value="Prideti sveikinimo vieta",notes="Prideda sveikinimo vieta")
    public void pridetiSveikinimoVieta(@RequestBody SveikinimoVieta sveikinimoVieta, @RequestBody Sveikinimas sveikinimas){
        sveikinimasService.pridetiSveikinimoVieta(sveikinimoVieta, sveikinimas);
    }

    @PostMapping("/pridetiSveikinima")
    @ApiOperation(value="Prideti sveikinima",notes="Prideda sveikinima")
    public void pridetiSveikinima(@RequestBody Sveikinimas sveikinimas){
        sveikinimasService.pridetiSveikinima(sveikinimas);
    }

    @PutMapping("/atnaujintiSveikinima")
    @ApiOperation(value="Atnaujinti sveikinima",notes="Atnaujina sveikinima")
    public void atnaujintiSveikinima(@RequestBody Sveikinimas sveikinimas){
        sveikinimasService.atnaujintiSveikinima(sveikinimas);
    }
}
