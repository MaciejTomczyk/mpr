package com.sklep;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();
		
		Klient p = new Klient("Maciej", "Tomczyk", produkty);	
		p.addProdukt(new Produkt("Johnnie_Walker_Red", "60"));
		p.addProdukt(new Produkt("Sobieski", "39"));
		p.addProdukt(new Produkt("Glenfiddich", "220"));

		p.addProdukt(new Produkt("Gorzka", "45"));
		p.editProdukt("Sobieski", "29"); // edycja ceny
		p.removeProdukt("Johnnie_Walker_Red");  // usuwanie produktu 
		p.printProdukty();
		p.clearlist(); //czyszczenie listy
		
		
		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.addProdukt(new Produkt("Bols_Blue", "56"));
		g.addProdukt(new Produkt("Sobieski", "39"));
		g.addProdukt(new Produkt("Johnnie_Walker_Blue", "400"));

		g.printProdukty();

		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++");
		p.search("Bols_Blue");//wyszukiwanie elementu
		System.out.println("+++++++++++++++++++++++++++++++");
		p.search("Sobieski");//wyszukiwanie elementu
	}

		
	}
