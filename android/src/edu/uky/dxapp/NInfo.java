package edu.uky.dxapp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NInfo implements Serializable {

	private String brand_name;
	private String item_name;
	private String brand_id;
	private String item_id;
	private int upc;
	private int item_type; //1= restaurant, 2=cpg, 3=USDA
	private int nf_calories;
	private int nf_calories_from_fat;
	private int nf_total_fat;
	private int nf_saturated_fat;
	private int nf_cholesterol;
	private int nf_sodium;
	private int nf_total_carbohydrate;
	private int nf_sugars;
	private int nf_protien;
	
	
	
	
	public String getBrandName() {
		return brand_name;
	}
	public void setBrandName(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getItemName() {
		return item_name;
	}
	public void setItemName(String item_name) {
		this.item_name = item_name;
	}
	public String getBrandId() {
		return brand_id;
	}
	public void setBrandId(String brand_id) {
		this.brand_id = brand_id;
	}
	public String getItemId() {
		return item_id;
	}
	public void setItemId(String item_id) {
		this.item_id = item_id;
	}
	public int getUpc() {
		return upc;
	}
	public void setUpc(int upc) {
		this.upc = upc;
	}
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}
	public int getNf_calories() {
		return nf_calories;
	}
	public void setNf_calories(int nf_calories) {
		this.nf_calories = nf_calories;
	}
	public int getNf_calories_from_fat() {
		return nf_calories_from_fat;
	}
	public void setNf_calories_from_fat(int nf_calories_from_fat) {
		this.nf_calories_from_fat = nf_calories_from_fat;
	}
	public int getNf_total_fat() {
		return nf_total_fat;
	}
	public void setNf_total_fat(int nf_total_fat) {
		this.nf_total_fat = nf_total_fat;
	}
	public int getNf_saturated_fat() {
		return nf_saturated_fat;
	}
	public void setNf_saturated_fat(int nf_saturated_fat) {
		this.nf_saturated_fat = nf_saturated_fat;
	}
	public int getNf_cholesterol() {
		return nf_cholesterol;
	}
	public void setNf_cholesterol(int nf_cholesterol) {
		this.nf_cholesterol = nf_cholesterol;
	}
	public int getNf_sodium() {
		return nf_sodium;
	}
	public void setNf_sodium(int nf_sodium) {
		this.nf_sodium = nf_sodium;
	}
	public int getNf_total_carbohydrate() {
		return nf_total_carbohydrate;
	}
	public void setNf_total_carbohydrate(int nf_total_carbohydrate) {
		this.nf_total_carbohydrate = nf_total_carbohydrate;
	}
	public int getNf_sugars() {
		return nf_sugars;
	}
	public void setNf_sugars(int nf_sugars) {
		this.nf_sugars = nf_sugars;
	}
	public int getNf_protien() {
		return nf_protien;
	}
	public void setNf_protien(int nf_protien) {
		this.nf_protien = nf_protien;
	}
		
	
	
}