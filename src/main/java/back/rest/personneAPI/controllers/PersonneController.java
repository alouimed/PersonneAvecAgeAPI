package back.rest.personneAPI.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.rest.personneAPI.entities.Personne;
import back.rest.personneAPI.services.PersonneService;


@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping("/add")
    public Personne createPersonne(@Valid @RequestBody  Personne personne) {
        return personneService.ajoutPersonne(personne);
    }

    @GetMapping("/list")
    public List<Personne> getAllPersonnes() {
    return personneService.getAllPersonnes();
    }

}
