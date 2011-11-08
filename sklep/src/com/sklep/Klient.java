package com.sklep;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.List;

public class Klient {

	private PropertyConfigurator logConfig = new PropertyConfigurator();
	private Logger logger = Logger.getLogger(Klient.class);

	public String name;
	public String surname;

	public void czyscliste() {
		do {
			produkty.remove(0);
		} while (produkty.size() != 0);
		logger.info("Wyczyszczono liste");

	}

	public void wypiszProdukt() {
		for (Produkt g : produkty) {
			g.wypiszProdukt();
		}

	}

	public void dodajProdukt(String nazwa, int cena) throws MyException {
		if (cena > 0) {
			produkty.add(new Produkt(nazwa, cena));
			logger.info("Dodano nowy produkt " + nazwa + "||Cena: " + cena);
		}
		if (cena <= 0)
			throw new MyException("Cena nie moze byc ponizej zera");
	}

	public void usunProdukt(String nazwa) {
		produkty.remove(szukaj(nazwa));
		logger.info("Usunięto gre " + nazwa);
	}

	public void szukajProduktu(String nazwa) {
		System.out
				.println("Szukany produkt: " + szukaj(nazwa).wezNazwa()
						+ " znajduje się na pozycji "
						+ produkty.indexOf(szukaj(nazwa)));

	}

	public void zmienProdukt(String nazwa, int cenaNowa) throws MyException {
		if (cenaNowa > 0) {
			int z = szukaj(nazwa).wezCena();
			produkty.set(produkty.indexOf(szukaj(nazwa)), new Produkt(nazwa,
					cenaNowa));
			logger.info("Edytowano produkt " + nazwa + " cena zmieniona z " + z
					+ " zl " + " na " + cenaNowa + " zl");
		}
		if (cenaNowa <= 0)
			throw new MyException("Edytowana cena nie może być poniżej zera");
	}

	public Produkt szukaj(String nazwa) {
		for (Produkt g : produkty) {
			if (g.wezNazwa().equals(nazwa)) {
				return g;
			}
		}
		return szukaj(nazwa);
	}

	public List<Produkt> produkty = new ArrayList<Produkt>();

	public Klient(String name, String surname, List<Produkt> produkty) {
		this.produkty = produkty;
		this.name = name;
		this.surname = surname;
	}

	public void wyswietlProdukty() {
		for (Produkt c : produkty)
			c.wyswietlProdukt();
		System.out.println("Klient: " + name + " " + surname);
		System.out.println("-------------------------------");
	}

}
