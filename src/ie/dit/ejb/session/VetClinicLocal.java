package ie.dit.ejb.session;

import ie.dit.ejb.entity.Animal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface VetClinicLocal {
	
	public void deleteAllAnimals();
	
	public void newAnimal(String owner, String Animal);
	
	public List<Animal> getAllAnimals();
	
	public List<Animal> getAnimalsByOwner(String owner);
}
