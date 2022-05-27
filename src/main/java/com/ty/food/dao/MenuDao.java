package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.Menu;

public class MenuDao {
	
	public Menu saveMenu(Menu menu) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
       if(menu!=null) {
    	   entityTransaction.begin();
    	   entityManager.persist(menu);
    	   entityTransaction.commit();
    	   System.out.println("Menu of particular row added");
       }else {
    	   System.out.println("Not added");
       }
		return null;
	}
	
	
	 public List<Menu> getAllMenus(){
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
		
			 String sql="SELECT m FROM Menu m";
			 Query query=entityManager.createQuery(sql);
			 
			 return query.getResultList();
			 
		 }
	 
	 
	 

}
