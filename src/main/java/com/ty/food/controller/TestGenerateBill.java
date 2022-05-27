package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.Bill;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGenerateBill {
	public static void main(String[] args) {
		FoodOrderService foodOrderService=new FoodOrderService();
		
		FoodOrderDao foodOrderDao=new FoodOrderDao();
		List<Bill > bills=new ArrayList();
		List<Item> items = new ArrayList();

		for(Item item:foodOrderDao.getFoodById(1).getItem()) {
			Bill bill=new Bill();
			bill.setItem(item.getName());
			bill.setCost(item.getCost());
			bill.setQuantity(item.getQuantity());
			bill.setTotal(item.getCost()*item.getQuantity());
			bills.add(bill);
		}
		
		double total=0;
		for(Bill bill:bills) {
			System.out.println(bill);
			total+=bill.getTotal();
		}
		System.out.println("Total amount for the order "+total);
		System.out.println("Offer applied for 10% off of purchase over 1000");
		double b=foodOrderService.generateBill(1);
		System.out.println(b);
	}

}
