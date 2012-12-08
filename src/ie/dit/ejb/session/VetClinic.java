package ie.dit.ejb.session;

import ie.dit.ejb.entity.Animal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VetClinic implements VetClinicLocal, ClinicRemote {

	@PersistenceContext
	EntityManager em;

	public void createAnimal(String owner, String animal) {

		Animal animals = new Animal(owner, animal);
		em.persist(animals);
	}


	public List<Animal> getAllAnimals() {

		 return (List<Animal>) this.em.createNamedQuery("Animal.findAll").getResultList();		 
	}


	public List<Animal> getAnimalsByOwner(String owner){
		
		Query query = this.em.createNamedQuery("Animal.findByOwner");
		query.setParameter("a", owner);
		
		return (List<Animal>)query.getResultList();
	}
	
	public void deleteAllAnimals(){
		
		List<Animal> animals = getAllAnimals();
		
		for (Animal b : animals){
			em.remove(b);
		}
	}


	@Override
	public void newAnimal(String owner, String Animal) {
	}




}
