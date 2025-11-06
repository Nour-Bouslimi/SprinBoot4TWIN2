package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.repository.ChefCuisinierRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class ChefCuisinierService implements ChefCuisinierInterface{

    private ChefCuisinierRepo chefCuisinierRepo;
    @Override
    public List<ChefCuisinier> retrieveAllChefs() {
        return chefCuisinierRepo.findAll();
    }

    @Override
    public ChefCuisinier retrieveChef(Long idChefCuisinier) {
        return chefCuisinierRepo.findById(idChefCuisinier).orElse(null);
    }

    @Override
    public ChefCuisinier addChef(ChefCuisinier c) {
        return chefCuisinierRepo.save(c);
    }

    @Override
    public ChefCuisinier updateChef(ChefCuisinier c) {
        return chefCuisinierRepo.save(c);
    }

    @Override
    public void removeChef(Long idChefCuisinier) {
        chefCuisinierRepo.deleteById(idChefCuisinier);
    }

    @Override
    public List<ChefCuisinier> addChef(List<ChefCuisinier> chefCuisiniers) {
        return chefCuisinierRepo.saveAll(chefCuisiniers);
    }
}
