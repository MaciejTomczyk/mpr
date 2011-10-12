package com.sklep;
 
import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
        public static void main(String[] args) {
                System.out.println("+++++++++++++++++++++++++++++++");
 
                int f = 0;
                int i = 0;
                List<Produkt> produkty = new ArrayList<Produkt>();
                produkty.add(new Produkt("Johnnie Walker Red ", "60"));
                f++;
                produkty.add(new Produkt("Sobieski", "39"));
                f++;
                produkty.add(new Produkt("Glenfiddich", "220"));
                f++;
                Klient p = new Klient("Maciej", "Tomczyk", produkty);
                p.printProdukty();
                for (i = 0; i < f; i++) {
                        produkty.remove(0);
                }
 
 
                produkty.add(new Produkt("Bols Blue", "56"));
                f++;
                produkty.add(new Produkt("Sheridans", "66"));
                f++;
                produkty.add(new Produkt("Johnnie Walker Blue", "400"));
 
                Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
                g.printProdukty();
 
        }
}
 