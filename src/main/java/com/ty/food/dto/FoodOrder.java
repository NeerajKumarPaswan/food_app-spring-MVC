package com.ty.food.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private long phone;

private double cost;



@OneToMany(mappedBy = "foodOrder")
private List<Item> item;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public List<Item> getItem() {
	return item;
}
public void setItem(List<Item> item) {
	this.item = item;
}


public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}

}
