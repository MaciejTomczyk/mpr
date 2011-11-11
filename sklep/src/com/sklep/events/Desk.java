package com.sklep.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sklep.Product;

public class Desk {

	private Product product;
	
	private List processes= new ArrayList();
	
	public Product getProduct() {
		return product;
		}

		public void setProduct(Product product) {
		this.product = product;
		}
	
	
	
	
	public synchronized void addProcess(IProductProcesses process){
		processes.add(process);
			
	}
	
	public synchronized void removeProcess(IProductProcesses process){
		processes.remove(process);
			
	}	
	
	public synchronized void executeProcesses(){
		
		ProductEvent Event=new ProductEvent(this,product);
		
		Iterator proc = processes.iterator();
		while(proc.hasNext()){
			( (IProductProcesses) proc.next() ).processProduct(Event);
		}
		

		
	}
		
public static class CleanProduct implements IProductProcesses
{

		public void processProduct(ProductEvent Event)
			{
		System.out.println(Event.getProduct().getName()+" product has been cleaned.");
			}

}


public static class ChangeBoxProduct implements IProductProcesses{

	public void processProduct(ProductEvent Event){
		System.out.println(Event.getProduct().getName()+" the box has been changed.");
	}

}

	
	
	
	
	
	
	
}
