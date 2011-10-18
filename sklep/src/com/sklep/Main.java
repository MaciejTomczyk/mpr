package com.sklep;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();
		
	
		produkty.add(new Produkt("Johnnie Walker Red ", "60"));
		produkty.add(new Produkt("Sobieski", "39"));
		produkty.add(new Produkt("Glenfiddich", "220"));
		Klient p = new Klient("Maciej", "Tomczyk", produkty);
		p.printProdukty();
		do {
			produkty.remove(0);

		} while (produkty.size() != 0);

		produkty.add(new Produkt("Bols Blue", "56"));
		produkty.add(new Produkt("Sheridans", "66"));
		produkty.add(new Produkt("Johnnie Walker Blue", "400"));
		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.printProdukty();

	}

		
	}
