package com.ty.food.service;
import static com.ty.food.dto.Tax.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		
	FoodOrderDao foodOrderdao=new FoodOrderDao();
	    return foodOrderdao.saveOrder(foodOrder);
		
	}
	
	public void getFoodById(int id) {
		FoodOrderDao foodOrderDao=new FoodOrderDao();
		foodOrderDao.getFoodById(id);
	}
	
	public FoodOrder getTotal(List<Item> items) {
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	   	EntityManager entityManager = entityManagerFactory.createEntityManager();
	  	EntityTransaction entityTransaction = entityManager.getTransaction();
	  	
		FoodOrderDao foodOrderDao=new FoodOrderDao();
          double d= foodOrderDao.getTotal(items);
   	
  		FoodOrder foodOrder=entityManager.find(FoodOrder.class,3);
  		 foodOrder.setCost(d);
  		entityTransaction.begin();
  		entityManager.merge(foodOrder);
  		entityTransaction.commit();
         
  		return foodOrder;
	}
	
	public double generateBill(int id) {
		FoodOrderDao foodOrderDao=new FoodOrderDao();

		FoodOrder foodOrder=foodOrderDao.getFoodById(id);
		double offer=0;
		if(foodOrderDao.getTotal(foodOrder.getItem())>1000) {
			offer=foodOrderDao.getTotal(foodOrder.getItem())/10;
		}
		double a=(foodOrderDao.getTotal(foodOrder.getItem())/SGST)+(foodOrderDao.getTotal(foodOrder.getItem())/CGST);
		return foodOrderDao.getTotal(foodOrder.getItem())-offer+a;
	}
}
