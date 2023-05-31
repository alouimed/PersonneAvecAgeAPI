package back.rest.personneAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import back.rest.personneAPI.entities.Personne;

//import back.rest.personneAPI.entities.Personne;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    List<Personne> findAllByOrderByNom();

}