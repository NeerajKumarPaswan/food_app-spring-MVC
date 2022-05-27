package com.ty.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		for (Item item : foodOrder.getItem()) {
			entityManager.persist(item);
		}

		entityManager.persist(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}

	public FoodOrder getFoodById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		if (foodOrder != null) {
			System.out.println(foodOrder.getName());
			System.out.println(foodOrder.getPhone());

			List<Item> items = foodOrder.getItem();
			for (Item item : items) {
				System.out.println(item.getName());
				System.out.println(item.getQuantity());
				System.out.println(item.getCost());
			}
		} else {
			System.out.println("No food of above id found");
		}
		return foodOrder;
	}

	public double getTotal(List<Item> items) {
		double total = 0;
		for (Item item : items) {
			total = total + item.getCost()*item.getQuantity();
              
		} 

		return total;

	}
}
