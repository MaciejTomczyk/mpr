package com.sklep;
 
public class Produkt implements iProdukt {
        public ProduktMarks nazwa;
        public String cena;
 
        public Produkt(ProduktMarks nazwa, String cena) {
                this.nazwa = nazwa;
                this.cena = cena;
        }
 
        public void printProdukt() {
                System.out.println("Nazwa: " + nazwa + " ||Cena: " + cena+" zl");
        }
}