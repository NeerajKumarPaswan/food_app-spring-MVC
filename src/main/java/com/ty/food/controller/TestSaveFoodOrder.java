package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;
import com.ty.food.service.FoodOrderService;

public class TestSaveFoodOrder {
public static void main(String[] args) {
	FoodOrderService foodOrderService=new FoodOrderService();
	Menu menu=new Menu();
	FoodOrder foodOrder=new FoodOrder();
	foodOrder.setName("Rashmi");
	foodOrder.setPhone(7795446512l);
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	Menu menu1=entityManager.find(Menu.class,1);
    Item item1=new Item();
	item1.setName(menu1.getName());
	item1.setQuantity(9);
	item1.setCost(menu1.getCost());
	
	Menu menu2=entityManager.find(Menu.class, 2);
	Item item2=new Item();
	item2.setName(menu2.getName());
	item2.setQuantity(3);
	item2.setCost(menu2.getCost());
	
	List<Item> items =new ArrayList();
	items.add(item1);
	items.add(item2);
	
	
	foodOrder.setItem(items);
	item1.setFoodOrder(foodOrder);
	item2.setFoodOrder(foodOrder);

	foodOrderService.saveOrder(foodOrder);
	 
	foodOrder=foodOrderService.getTotal(items);
	
}
}
