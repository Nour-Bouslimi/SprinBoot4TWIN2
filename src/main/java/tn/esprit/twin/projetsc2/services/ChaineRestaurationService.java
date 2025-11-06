package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.repository.ChaineRestaurationRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
@AllArgsConstructor // Pour l'injection de dépendances via le constructeur fy 3oudh @Autowired 3la kol instance nasna3ha nesta3mel @AllArgsConstructor bch yinjecty 2ay instance nesta3melha
public class ChaineRestaurationService  implements ChaineRestaurationInterface{
    @Autowired
    private ChaineRestaurationRepo chaineRestaurationRepo;
    @Override
    public List<ChaineRestauration> retrieveAllChaineRestauration() {
        return chaineRestaurationRepo.findAll();
    }

    @Override
    public ChaineRestauration retrieveChaineRestauration(Long idChaineRestauration) {
        return chaineRestaurationRepo.findById(idChaineRestauration).orElse(null);
    }

    @Override
    public ChaineRestauration addChaineRestauration(ChaineRestauration c) {
        return chaineRestaurationRepo.save(c);
    }

    @Override
    public ChaineRestauration updateChaineRestauration(ChaineRestauration c, Long idChaineRestauration) {
        c.setIdChaineRestauration(idChaineRestauration);
        return chaineRestaurationRepo.save(c);
    }

    @Override
    public void removeChaineRestauration(Long idChaineRestauration) {
        chaineRestaurationRepo.deleteById(idChaineRestauration);
    }

    @Override
    public List<ChaineRestauration> addChaineRestaurations(List<ChaineRestauration> ChaineRestaurations) {
        return chaineRestaurationRepo.saveAll(ChaineRestaurations);
    }


}
