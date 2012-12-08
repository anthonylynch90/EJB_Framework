package ie.dit.ejb.session;

import ie.dit.ejb.entity.Animal;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ClinicRemote {

	public void deleteAllAnimals();

	public void createAnimal(String owner, String animal);

	public List<Animal> getAllAnimals();

	public List<Animal> getAnimalsByOwner(String owner);
}
