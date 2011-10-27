package com.sklep;
 
public class Produkt implements iProdukt {
        public String nazwa;
        public int cena;
        public double procent;
 
        public Produkt(String nazwa, int cena) {
                this.nazwa = nazwa;
                this.cena = cena;
        }
 
        
    	public void ustalProcent(double procent) throws MyException
    	{
    		if(procent < 0)
    			throw new MyException("Procenty nie moga byc ujemne");
    		else
    			this.procent=procent;
    	}        
        
        
        
        
        public void wyswietlProdukt() {
                System.out.println("Nazwa: " + nazwa + " ||Cena: " + cena+" zl");
        }
        
        public  String wezNazwa() {
        	return nazwa;
        	}
       
        
}