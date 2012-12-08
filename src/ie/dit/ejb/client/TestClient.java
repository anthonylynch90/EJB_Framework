package ie.dit.ejb.client;

import ie.dit.ejb.entity.Animal;
import ie.dit.ejb.session.ClinicRemote;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestClient {
	
	public static void main(String[] args) {

		Context context;
		try {

			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			env.put(Context.PROVIDER_URL, "localhost:1099");

			context = new InitialContext(env);
			
			ClinicRemote beanRemote = (ClinicRemote) context.lookup("VetClinic/remote");
			
			
			
			

			beanRemote.createAnimal("John", "dog");
			beanRemote.createAnimal("Mary", "cat");
			beanRemote.createAnimal("Deirdre", "cow");

			List<Animal> animals = beanRemote.getAllAnimals();

			for (Animal b : animals) {
				System.out.println(b.toString());
			}

			animals = beanRemote.getAnimalsByOwner("John");

			for (Animal b : animals) {

				System.out.println(b.toString());
			}
			
			beanRemote.deleteAllAnimals();

		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
