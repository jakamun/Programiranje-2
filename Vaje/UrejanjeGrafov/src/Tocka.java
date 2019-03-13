import java.util.*;

public class Tocka { 
	// za eno to�ko vemo kako ji je ime in kateri so njeni sosedi, ima dve komponenti
	
	String ime;
	
	double x, y;
	
	Set<Tocka> sosedi; // tip sosedov je tocka, z Set smo ustvarili mno�ico to�k
	
	// isto kot smo vedno nardil najprej prazen seznam, in potem not dodajal tocke itd.
	public Tocka(String ime) { //to je konstruktor nima tipa pred imenom, ker to ni metoda
		// konstruktorji so ubistvu tipi, z konstruktorjem Tocka, v nekem drugem razredu ustvarmo nove tocke, na zacetku vsaka
		//ki jo ustvarimo nima sosedov potem pa ji jih dodamo, isto nova tabela je na za�etku prazna pa ji potem elemente dodajamo
		// tu ustvarimo novo izolirano tocko
		this.ime = ime; 
// isto kot self. v pythonu, to "poklice" zgornjo komponento ime, ime je tudi lokalna spremenljivka, delal bi tud �e bi lokalno spremenljivko druga� poimenoval
		sosedi = new HashSet<Tocka> (); // to je klic konstruktorja
		//Set ni razred je le vmesnik, zato novega objekta Set ne moremo naredit,rabimo implementacijo vmesnika
		//--> HashSet
		//tudi lahko: this.sosedi, �e nimamo 2 isti imeni, raje ne uporabljamo
		x = y = 0;
	}
	
	// imamo pa �e dve metodi
	
	public int stopnja () { // to je metoda zato spredaj int ker vra�a integer
		// ne rabimo dat parametra ker bo avtomatsko dala this.
		return sosedi.size();
	}
	
	public String toString() {
		return ime;
	}
	
}
