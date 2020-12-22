package lt2020.sveikinimai.services;

import lt2020.sveikinimai.DAO.SveikinimoAdresasDAO;
import lt2020.sveikinimai.entities.SveikinimoAdresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SveikinimoAdresoService {

    @Autowired
    public SveikinimoAdresasDAO sveikinimoAdresasDAO;

    public Collection<SveikinimoAdresas> gautiSveikinimoAdresus(){
        return sveikinimoAdresasDAO.findAll();
    }

    public void pridetiSveikinimoAdresa(SveikinimoAdresas sveikinimoAdresas){
        sveikinimoAdresasDAO.save(sveikinimoAdresas);
    }

    public void istrintiSveikinimoAdresa(int id){
        sveikinimoAdresasDAO.deleteById(id);
    }

    public void atnaujintiSveikinimoAdresa(SveikinimoAdresas sveikinimoAdresas){
        boolean checkIfExists = gautiSveikinimoAdresus()
                .stream()
                .anyMatch(sv -> sv.getId() == sveikinimoAdresas.getId());
        if(checkIfExists){
            sveikinimoAdresasDAO.save(sveikinimoAdresas);
        } else {
            throw new IllegalArgumentException("Toks sveikinimo adresas neegzistuoja");
        }
    }
}
