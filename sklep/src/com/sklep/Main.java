package com.sklep;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws MyException {

		PropertyConfigurator.configure("Log4J.properties");

		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();

		Klient z = new Klient("Paweł", "Tomczyk", produkty);

		z.dodajProdukt("Malibu", 20);
		try {
			z.dodajProdukt("Likier", -2);
		} catch (MyException e) {
			logger.error(e.getMessage());
		}
		z.wyswietlProdukty();
		z.czyscliste();

		Klient p = new Klient("Maciej", "Tomczyk", produkty);
		p.dodajProdukt("Johnnie_Walker_Red", 60);
		p.dodajProdukt("Sobieski", 39);
		p.dodajProdukt("Glenfiddich", 220);

		p.dodajProdukt("Gorzka", 45);
		p.usunProdukt("Sobieski"); // usuwanie produktu
		// czyszczenie listy

		try {
			p.zmienProdukt("Glenfiddich", 190);// edycja ceny
		} catch (MyException e) {
			logger.error(e.getMessage());
		}
		p.wyswietlProdukty();
		p.czyscliste();

		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.dodajProdukt("Bols_Blue", 56);
		g.dodajProdukt("Sobieski", 39);
		g.dodajProdukt("Johnnie_Walker_Blue", 400);

		g.wyswietlProdukty();

		System.out.println("");
		System.out.println("-------------------------------");
		p.szukajProduktu("Bols_Blue");// wyszukiwanie elementu
		System.out.println("-------------------------------");
		p.szukajProduktu("Sobieski");// wyszukiwanie elementu
	}

}
