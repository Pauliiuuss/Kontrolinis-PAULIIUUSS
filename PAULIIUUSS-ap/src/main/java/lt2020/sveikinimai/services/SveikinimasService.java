package lt2020.sveikinimai.services;

import lt2020.sveikinimai.DAO.SveikinimasDAO;
import lt2020.sveikinimai.entities.Sveikinimas;
import lt2020.sveikinimai.entities.SveikinimoVieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Service
public class SveikinimasService {

    @Autowired
    public SveikinimasDAO sveikinimasDAO;

    public Collection<Sveikinimas> gautiSveikinimus(){
        return sveikinimasDAO.findAll();
    }

    public void istrintiSveikinima(int id){
        sveikinimasDAO.deleteById(id);
    }

    public void pridetiSveikinimoVieta(SveikinimoVieta sveikinimoVieta, Sveikinimas sveikinimas){
        sveikinimas.setSveikinimoVieta(sveikinimoVieta);
    }

    public void pridetiSveikinima(@RequestBody Sveikinimas sveikinimas){
            sveikinimasDAO.save(sveikinimas);
    }

    public void atnaujintiSveikinima(@RequestBody Sveikinimas sveikinimas){
        boolean checkIfExists = gautiSveikinimus()
                .stream()
                .anyMatch(sv -> sv.getId() == sveikinimas.getId());
        if(checkIfExists){
            sveikinimasDAO.save(sveikinimas);
        } else {
            throw new IllegalArgumentException("Sveikinimas su tokiu ID neegzistuoja");
        }
    }


}
