package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.repository.ChefCuisinierRepo;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class ChefCuisinierService implements ChefCuisinierInterface{

    private ChefCuisinierRepo chefCuisinierRepo;
    private MenuRepo menuRepo;
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
    public ChefCuisinier updateChef(ChefCuisinier c, Long idChefCuisinier) {
        c.setIdChefCuisinier(idChefCuisinier);
        return chefCuisinierRepo.save(c);
    }

    @Override
    public void removeChef(Long idChefCuisinier) {
        chefCuisinierRepo.deleteById(idChefCuisinier);
    }

    @Override
    public List<ChefCuisinier> addChefs(List<ChefCuisinier> chefCuisiniers) {
        return chefCuisinierRepo.saveAll(chefCuisiniers);
    }

    @Override
    public ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu) {
        ChefCuisinier chefCuisinier=chefCuisinierRepo.findById(idChefCuisinier).orElse(null);
        Menu menu =menuRepo.findById(idMenu).orElse(null);
        if(chefCuisinier!=null && menu!=null){
            //affecter le chef cuisinier au menu
            menu.getChefCuisiniers().add(chefCuisinier);
            return chefCuisinierRepo.save(chefCuisinier);
        }
    return null;
    }

    @Override
    public ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChefCuisinier) {
        ChefCuisinier chefCuisinier=chefCuisinierRepo.findById(idChefCuisinier).orElse(null);
        Menu menu =menuRepo.findById(idMenu).orElse(null);
        if(chefCuisinier!=null && menu!=null){
            //désaffecter le chef cuisinier du menu
            menu.getChefCuisiniers().remove(chefCuisinier);
            return chefCuisinierRepo.save(chefCuisinier);

        }
       return null;
    }
}
