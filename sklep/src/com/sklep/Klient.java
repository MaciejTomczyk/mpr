package com.sklep;
 
import java.util.ArrayList;
import java.util.List;
 
public class Klient {
        public String name;
        public String surname;
        public String nickname;
 
        
        public void addProdukt(Produkt c)
        {
        	produkty.add(c);
        	
        }
        
        public void removelist()
        {
        	do{produkty.remove(0);}while(produkty.size()!=0);
        	
        }    
        
        
        
        
        public String toString()
        		{
        		return name +"kupil "+produkty.size()+" produkty."; 
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
 