package com.sklep.project;

public class Product implements IProduct  {
	public ProductMarks mark;
	public int price;
	public double code;

	public Product(ProductMarks mark, int price) {
		this.mark = mark;
		this.price = price;
	}

	public Product(ProductMarks mark, double code){
		this.mark=mark;
		this.code=code;
		
	}
	
	public void setPrice(int price) throws PriceException {
		if (price < 0)
			throw new PriceException("Price cannot be lower than 0");
		else
			this.price = price;
	}

	public void printProduct() {
		System.out.println("Name: " + mark + " ||Price: " + price + " zl");
	}

	public ProductMarks getName() {
		return this.mark;
	}

	public Integer getPrice() {
		return price;
	}

	public void setName(ProductMarks mark){
	this.mark=mark;
		}

	public double getCode(){
		return this.code;
	}

	public void setCode(double code) throws CodeException {
		if (code < 0)
			throw new CodeException("Code cannot be lower than 0");
		else
			this.code = code;
	}





}