package com.sklep;
 
import java.util.ArrayList;
import java.util.List;
 
public class Klient {
        public String name;
        public String surname;
        public String nickname;
 
        
		public void czyscliste() {
			do{produkty.remove(0);}while(produkty.size()!=0);
			
		}
        
        public void dodajProdukt(Produkt c)
        {
        	produkty.add(c);
        	
        }
          
        public void usunProdukt(String nazwa) {
        	int pozycja = 0;
        	for (Produkt g : produkty) {
        			if (g.wezNazwa().equals(nazwa)) {produkty.remove(pozycja);break;}
        			pozycja++;
        					}
        	
        	}
        
        public void szukaj(String nazwa)
        {
        int pozycja = 0;
        for (Produkt g : produkty) {
        if (g.wezNazwa().equals(nazwa)) {
        System.out.println("Szukany produkt " + g.wezNazwa() + " znajduje się na pozycji " + pozycja );
        }
        pozycja++;
        }
        }
        
        public void zmienProdukt(String nazwa, String cenaNowa) {
        	int pozycja = 0;
        	for (Produkt g : produkty) {
        	if (g.wezNazwa().equals(nazwa)) {
        	produkty.set(pozycja, new Produkt(nazwa, cenaNowa));
        	}
        	pozycja++;
        	}
        	}


        
        public List<Produkt> produkty = new ArrayList<Produkt>();
 
        public Klient(String name, String surname, List<Produkt> produkty) 
        {
                this.produkty = produkty;
                this.name = name;
                this.surname = surname;
        }
 
        public void wyswietlProdukty() 
        {
                for (Produkt c : produkty)
                        c.wyswietlProdukt();
                System.out.println("Klient: " + name + " "  + surname);
                System.out.println("+++++++++++++++++++++++++++++++");
        }


}
 