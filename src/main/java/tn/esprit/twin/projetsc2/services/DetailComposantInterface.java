package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.entities.DetailComposant;

import java.util.List;

public interface DetailComposantInterface {

    List<DetailComposant> retrieveAlldetails();
     DetailComposant retrieveDetail(Long idDetail);
    DetailComposant addDetail(DetailComposant d);
    DetailComposant updateDetail(DetailComposant d);
    void removeDetail(Long idDetail);
    List<DetailComposant> addDetails(List<DetailComposant> detailComposants);
}
