package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestSaveMenu {
	public static void main(String[] args) {
		MenuService menuService=new MenuService();
		Menu menu=new Menu();
		menu.setName("kebab");
		menu.setDescription("pakistani");
		menu.setCost(1150);
		menu.setType("Non Veg");
		menu.setOffer("Nil");
		menu.setImage("image source");
		menuService.saveMenu(menu);
		
		
	}

}
