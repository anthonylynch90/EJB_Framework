package ie.dit.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({		
	@NamedQuery(name = "Animal.findByOwner", query = "select o from Animal o where o.owner=:a"),
	@NamedQuery(name = "Animal.findAll", query = "select o from Animal o")
})

public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String owner;

	private String animal;

	public Animal() {
		super();
	}

	public Animal(String owner, String animal) {
		super();
		this.owner = owner;
		this.animal = animal;
	}

	public String toString() {

		return "Animal: " + getId() + " Owner " + getOwner() + " Pet "	+ getAnimal();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getOwner() {
		return owner;
	}

	public void setTitle(String owner) {
		this.owner = owner;
	}
}
