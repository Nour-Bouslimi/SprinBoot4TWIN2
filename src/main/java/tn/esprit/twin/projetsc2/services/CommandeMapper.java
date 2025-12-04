package tn.esprit.twin.projetsc2.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.twin.projetsc2.entities.Commande;

import java.util.List;

@Mapper(componentModel = "spring") //pour dire que c'est un mapper
public interface CommandeMapper {

    @Mapping(source = "menu.libelleMenu", target = "libelleMenu")
    @Mapping(source="client.identifiant",target="identifiant")

    CommandeDTO toDto(Commande commande);
    List<CommandeDTO> toDtoList(List<Commande> commandes);




}
