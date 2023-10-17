package com.jorgegonzales.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//JPA/Hibernate > Database
	//Static List
	public static List<User> users = new ArrayList<>();
	private static Integer usersCount = 0;
	static {
		users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
		//long way
		/*
		 * Predicate<? super User> predicate = user -> user.getId().equals(id);
		 * return users.stream().filter(predicate).findFirst().get();
		 */
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);	
	}
	
	
	
}
