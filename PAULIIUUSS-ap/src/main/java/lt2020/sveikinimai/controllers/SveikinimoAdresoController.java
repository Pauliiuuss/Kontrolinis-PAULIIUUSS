package lt2020.sveikinimai.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sveikinimai.entities.SveikinimoAdresas;
import lt2020.sveikinimai.services.SveikinimoAdresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api("sveikinimoAdresas")
@RequestMapping("/sveikinimoAdresai")
public class SveikinimoAdresoController {

    @Autowired
    public SveikinimoAdresoService sveikinimoAdresoService;

    @GetMapping
    @ApiOperation(value="Gauti sveikinimo adresus",notes="Grazina sveikinimo adresu sarasa")
    public Collection<SveikinimoAdresas> gautiSveikinimoAdresus(){
        return sveikinimoAdresoService.gautiSveikinimoAdresus();
    }

    @PostMapping
    @ApiOperation(value="Prideti sveikinimo adresa",notes="Prideda sveikinimo adresa")
    public void pridetiSveikinimoAdresa(SveikinimoAdresas sveikinimoAdresas){
        sveikinimoAdresoService.pridetiSveikinimoAdresa(sveikinimoAdresas);
    }

    @DeleteMapping("{sveikinimoAdresoId}")
    @ApiOperation(value="Istrinti sveikinimo adresa",notes="Istrina sveikinimo adresa")
    public void istrintiSveikinimoAdresa(@PathVariable("sveikinimoAdresoId") int id){
        sveikinimoAdresoService.istrintiSveikinimoAdresa(id);
    }

    @PutMapping
    @ApiOperation(value="Atnaujinti sveikinimo adresa",notes="Atnaujina sveikinimo adresa")
    public void atnaujintiSveikinimoAdresa(SveikinimoAdresas sveikinimoAdresas){
        sveikinimoAdresoService.atnaujintiSveikinimoAdresa(sveikinimoAdresas);
    }
}
