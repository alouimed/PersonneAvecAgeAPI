package back.rest.personneAPI.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import back.rest.personneAPI.entities.Personne;
import back.rest.personneAPI.entities.PersonneAvecAge;
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

    public List<PersonneAvecAge> getAllPersonnes() {
        List<Personne> personnes = personneRepository.findAllByOrderByNom();
        
        List<PersonneAvecAge> personnesAvecAge = new ArrayList<>();
        
        LocalDate dateCourant = LocalDate.now();
        for (Personne personne : personnes) {
            LocalDate dateNaissance = personne.getDateNaissance();
            int age = Period.between(dateNaissance, dateCourant).getYears();
            PersonneAvecAge personneAvecAge = new PersonneAvecAge(personne, age);
            personnesAvecAge.add(personneAvecAge);
         
        }
        return personnesAvecAge;
    
    }
}