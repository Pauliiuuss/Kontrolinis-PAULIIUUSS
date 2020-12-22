package lt2020.sveikinimai.services;

import lt2020.sveikinimai.DAO.SveikinimoVietaDAO;
import lt2020.sveikinimai.entities.SveikinimoVieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SveikinimoVietaService {

    @Autowired
    public SveikinimoVietaDAO sveikinimoVietaDAO;

    public Collection<SveikinimoVieta> gautiSveikinimoVietas() {
        return sveikinimoVietaDAO.findAll();
    }

    public void istrintiSveikinimoVieta(int id){
        sveikinimoVietaDAO.deleteById(id);
    }

    public void pridetiSveikinimoVieta(SveikinimoVieta sveikinimoVieta){
        sveikinimoVietaDAO.save(sveikinimoVieta);
    }

    public void atnaujintiSveikinimoVieta(SveikinimoVieta sveikinimoVieta){
        boolean checkIfExists = gautiSveikinimoVietas()
                .stream()
                .anyMatch(sv -> sv.getId() == sveikinimoVieta.getId());
        if(checkIfExists){
            sveikinimoVietaDAO.save(sveikinimoVieta);
        } else {
            throw new IllegalArgumentException("Tokia sveikinimo vieta neegzistuoja");
        }
    }
}
