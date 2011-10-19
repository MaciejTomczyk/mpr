package com.sklep;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();
		
	
		produkty.add(new Produkt(ProduktMarks.Johnnie_Walker_Red, "60"));
		produkty.add(new Produkt(ProduktMarks.Sobieski, "39"));
		produkty.add(new Produkt(ProduktMarks.Glenfiddich, "220"));
		Klient p = new Klient("Maciej", "Tomczyk", produkty);
		p.printProdukty();
		p.removelist();

		produkty.add(new Produkt(ProduktMarks.Bols_Blue, "56"));
		produkty.add(new Produkt(ProduktMarks.Sobieski, "66"));
		produkty.add(new Produkt(ProduktMarks.Johnnie_Walker_Blue, "400"));
		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.printProdukty();

	}

		
	}
