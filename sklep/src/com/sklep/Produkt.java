package com.sklep;
 
public class Produkt implements iProdukt {
        public String nazwa;
        public String cena;
 
        public Produkt(String nazwa, String cena) {
                this.nazwa = nazwa;
                this.cena = cena;
        }
 
        public void wyswietlProdukt() {
                System.out.println("Nazwa: " + nazwa + " ||Cena: " + cena+" zl");
        }
        
        public  String wezNazwa() {
        	return nazwa;
        	}
       
        
}