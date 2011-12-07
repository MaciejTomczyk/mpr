package com.sklep.project;

public class Product implements IProduct  {
	public ProductMarks mark;
	public double price;
	public float code;
	boolean box;

	public Product(ProductMarks mark, double price) {
		this.mark = mark;
		this.price = price;
	}

	public Product(ProductMarks mark, float code){
		this.mark=mark;
		this.code=code;
		
	}
	
	
	
	public void setPrice(double z) throws PriceException {
		if (z < 0)
			throw new PriceException("Price cannot be lower than 0");
		else
			this.price = z;
	}

	public void printProduct() {
		System.out.println("Name: " + mark + " ||Price: " + price + " zl");
	}

	public ProductMarks getName() {
		return this.mark;
	}

	public void setBox(){
		this.box=true;
		
	}
	
	public boolean getBox(){
		return this.box=box;
		
	}
	
	
	
	public double getPrice() {
		return price;
	}

	public void setName(ProductMarks mark){
	this.mark=mark;
		}

	public float getCode(){
		return this.code;
	}

	public void setCode(float code) throws CodeException {
		if (code < 0)
			throw new CodeException("Code cannot be lower than 0");
		else
			this.code = code;
	}

		
		
	}





