package com.sklep;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();
		
		Klient p = new Klient("Maciej", "Tomczyk", produkty);	
		p.dodajProdukt(new Produkt("Johnnie_Walker_Red", "60"));
		p.dodajProdukt(new Produkt("Sobieski", "39"));
		p.dodajProdukt(new Produkt("Glenfiddich", "220"));

		p.dodajProdukt(new Produkt("Gorzka", "45"));
		p.zmienProdukt("Sobieski", "29"); // edycja ceny
		p.usunProdukt("Sobieski");  // usuwanie produktu 
		p.wyswietlProdukty();
		p.czyscliste(); //czyszczenie listy
		
		
		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.dodajProdukt(new Produkt("Bols_Blue", "56"));
		g.dodajProdukt(new Produkt("Sobieski", "39"));
		g.dodajProdukt(new Produkt("Johnnie_Walker_Blue", "400"));

		g.wyswietlProdukty();

		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++");
		p.szukaj("Bols_Blue");//wyszukiwanie elementu
		System.out.println("+++++++++++++++++++++++++++++++");
		p.szukaj("Sobieski");//wyszukiwanie elementu
	}

		
	}
