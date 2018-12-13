package db;

import java.util.List;

import domain.Person;

public interface PersonRepository {

	public abstract void add(Person person);

	public abstract void delete(String userId);

	public abstract Person get(String userId);
	public abstract Person getUserByName(String name);


	public abstract List<Person> getAll();
	
	public abstract Person getAuthenticatedUser(String email, String password);
	public abstract Person getUser(String email);

	public abstract void update(Person person);

}