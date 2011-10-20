package com.sklep;
 
import java.util.ArrayList;
import java.util.List;
 
public class Klient {
        public String name;
        public String surname;
        public String nickname;
 
        
		public void clearlist() {
			do{produkty.remove(0);}while(produkty.size()!=0);
			
		}
        
        public void addProdukt(Produkt c)
        {
        	produkty.add(c);
        	
        }
          
        public void removeProdukt(String nazwa) {
        	int pozycja = 0;
        	for (Produkt g : produkty) {
        	if (g.getNazwa().equals(nazwa)) {
        	produkty.remove(pozycja);break;
        	}
        	}
        	pozycja++;
        	}
        
        public void search(String nazwa)
        {
        int pozycja = 0;
        for (Produkt g : produkty) {
        if (g.getNazwa().equals(nazwa)) {
        System.out.println("Szukany produkt " + g.getNazwa() + " znajduje się na pozycji " + pozycja );
        }
        pozycja++;
        }
        }
        
        public void editProdukt(String nazwa, String cenaNowa) {
        	int pozycja = 0;
        	for (Produkt g : produkty) {
        	if (g.getNazwa().equals(nazwa)) {
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
 
        public void printProdukty() 
        {
                for (Produkt c : produkty)
                        c.printProdukt();
                System.out.println("Klient: " + name + " "  + surname);
                System.out.println("+++++++++++++++++++++++++++++++");
        }


}
 