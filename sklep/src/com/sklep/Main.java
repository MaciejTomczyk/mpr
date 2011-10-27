package com.sklep;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
public class Main {

	private static Logger logger= Logger.getLogger(Main.class);	
	
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("Log4J.properties");
		
		Produkt c =new Produkt("Malibu",20);

		try {
			c.ustalProcent(-22.0);
		} catch (MyException e) {

			logger.error(e);
			logger.fatal(e);
			logger.info(e);
			logger.warn(e);
		}
		
		
		
		
		
		
		System.out.println("+++++++++++++++++++++++++++++++");

		List<Produkt> produkty = new ArrayList<Produkt>();
		
		Klient p = new Klient("Maciej", "Tomczyk", produkty);	
		p.dodajProdukt("Johnnie_Walker_Red", 60);
		p.dodajProdukt("Sobieski", 39);
		p.dodajProdukt("Glenfiddich", 220);

		p.dodajProdukt("Gorzka", 45);
		p.zmienProdukt("Sobieski", 29); // edycja ceny
		p.usunProdukt("Sobieski");  // usuwanie produktu 
		p.wyswietlProdukty();
		p.czyscliste(); //czyszczenie listy
		
		
		Klient g = new Klient("Tadeusz", "Tomczyk", produkty);
		g.dodajProdukt("Bols_Blue", 56);
		g.dodajProdukt("Sobieski", 39);
		g.dodajProdukt("Johnnie_Walker_Blue", 400);

		g.wyswietlProdukty();

		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++");
		p.szukaj("Bols_Blue");//wyszukiwanie elementu
		System.out.println("+++++++++++++++++++++++++++++++");
		p.szukaj("Sobieski");//wyszukiwanie elementu
	}

		
	}
