package com.ty.food.controller;

import com.ty.food.service.FoodOrderService;

public class TestGetOrderById {
public static void main(String[] args) {
	FoodOrderService foodOrderService =new FoodOrderService();
	foodOrderService.getFoodById(1);
}
}
