package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryStub () {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", "M", Role.BIB);
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", "M", Role.LID);
		add(jan);
		Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", "V", Role.LID);
		add(an);
		Person Arnaud = new Person("arnaud@ucll.be", "a", "Arnaud", "Ancis", "M", Role.LID);
		add(Arnaud);
		Person Man = new Person("man@ucll.be", "t", "Man", "Man", "M", Role.LID);
		add(Man);
		jan.addFriend(an);
		jan.addFriend(Arnaud);

		an.addFriend(jan);
		an.addFriend(Arnaud);
		//an.addFriend(jan);
	}

	public Person getUser(String email){
		for (Map.Entry<String, Person> entry : persons.entrySet())
		{
			if (entry.getValue().getUserId().equals(email)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public Person getUserByName(String name){
		for (Map.Entry<String, Person> entry : persons.entrySet())
		{
			if (entry.getValue().getFirstName().equals(name)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}
}
