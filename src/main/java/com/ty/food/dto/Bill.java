package com.ty.food.dto;

public class Bill {
private String item;
private double cost;
private int quantity;
private double total;
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
@Override
public String toString() {
	return "Bill [item=" + item + ", cost=" + cost + ", quantity=" + quantity + ", total=" + total + "]";
}

}
