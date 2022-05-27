package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.User;


public class UserDao {

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		System.out.println("-All Good-");
		if (user != null) {
			return user;
		} else
			return null;
	}

	public User getUserById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		User user = entityManager.find(User.class, id);

		if (user != null) {
			System.out.println("Id id " + user.getId());
			System.out.println("Name is " + user.getName());
			System.out.println("Email id is is " + user.getEmail());
			System.out.println("Phone number is " + user.getPhone());
			System.out.println("Password is " + user.getPassword());
			return user;
		} else {
			System.out.println("User of the above id not found");
		}

		return null;
	}

	public boolean deleteUserById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			System.out.println("User of the following id deleted " + id);
			return true;
		} else {
			System.out.println("No User of such id found to delete");
		}
		return false;

	}

	public List<User> getAllUser() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT u FROM User u";

		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public void validateUser(String name, String password) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT user FROM User user WHERE user.name=?1 AND user.password=?2";

		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		query.setParameter(2, password);

		
		List<User> users = query.getResultList();

		if (users.size() > 0) {

			for (User user : users) {
				System.out.println("User id is =" + user.getId());
				System.out.println("Name is" + user.getName());
				System.out.println("Email is" + user.getEmail());
				System.out.println("Phone is  " + user.getPhone());
				System.out.println("Password is " + user.getPassword());
				System.out.println("----------------------------------------------------");
			}
		} else {
			System.out.println("Either Name or Password is invalid ");
		}
	}

}
