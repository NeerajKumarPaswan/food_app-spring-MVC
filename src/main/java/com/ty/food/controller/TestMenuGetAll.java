package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestMenuGetAll {
public static void main(String[] args) {
	MenuService menuService=new MenuService();

	
	List<Menu> menu=  menuService.getAllMenus();
	for(Menu m:menu) {
		System.out.println("Menu id "+m.getId());
		System.out.println("Menu name  "+m.getName());
		System.out.println("Description  "+m.getDescription());
		System.out.println("Cost "+m.getCost());
		System.out.println("Food type "+m.getType());
		System.out.println("Product image only for reference "+m.getImage());
		System.out.println("Offer applied for  "+m.getOffer());
		System.out.println("-------------------------------------------------------------------------");
	}
}
}
