package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.DetailComposant;
import tn.esprit.twin.projetsc2.repository.DetailComposantRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailComposantService implements DetailComposantInterface {
@Autowired
    private DetailComposantRepo detailComposantRepo;
    @Override
    public List<DetailComposant> retrieveAlldetails() {
        return detailComposantRepo.findAll();
    }

    @Override
    public DetailComposant retrieveDetail(Long idDetail) {
        return detailComposantRepo.findById(idDetail).orElse(null);
    }

    @Override
    public DetailComposant addDetail(DetailComposant d) {
        return detailComposantRepo.save(d);
    }

    @Override
    public DetailComposant updateDetail(DetailComposant d) {
        return detailComposantRepo.save(d);
    }

    @Override
    public void removeDetail(Long idDetail) {
        detailComposantRepo.deleteById(idDetail);

    }

    @Override
    public List<DetailComposant> addDetails(List<DetailComposant> detailComposants) {
        return detailComposantRepo.saveAll(detailComposants);
    }
}
