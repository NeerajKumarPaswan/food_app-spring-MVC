package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

public class MenuService {

	
	 public Menu saveMenu(Menu menu) {
		 MenuDao menuDao=new MenuDao();
		return menuDao.saveMenu(menu);
	 }
	 
	 public List<Menu> getAllMenus(){
		 MenuDao menuDao=new MenuDao(); 
          return menuDao.getAllMenus();

		 
	 }
}
