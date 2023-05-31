package back.rest.personneAPI.entities;

public class PersonneAvecAge extends Personne{
	
private int age;

public PersonneAvecAge(Personne personne, int age) {
    super(personne.getId(), personne.getNom(),personne.getPrenom(),personne.getDateNaissance());
    this.age = age;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

}
