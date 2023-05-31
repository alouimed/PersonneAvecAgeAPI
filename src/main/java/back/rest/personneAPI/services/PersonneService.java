package back.rest.personneAPI.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import back.rest.personneAPI.entities.Personne;
import back.rest.personneAPI.repositories.PersonneRepository;



@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public Personne ajoutPersonne(Personne personne) {
        LocalDate dateCourant = LocalDate.now();
        int age = Period.between(personne.getDateNaissance(), dateCourant).getYears();
        if (age > 150) {
            throw new IllegalArgumentException("l'age ne doit pas dépassé 150 ans.");
        }
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonnes() {
        List<Personne> personnes = personneRepository.findAllByOrderByNom();
        LocalDate dateCourant = LocalDate.now();
        personnes.forEach(p -> {
            int age = Period.between(p.getDateNaissance(), dateCourant).getYears();
            LocalDate dateNaissance = dateCourant.minusYears(age);
            p.setDateNaissance(dateNaissance);
        });
        return personnes;
    }
}