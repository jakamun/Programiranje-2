import java.util.*;

public class Tocka {
	
	String ime;
	
	Set<Tocka> sosedi; // tip sosedov je tocka Set pomeni da je mno�ica to�k
	
	// isto kot smo vedno nardil najprej prazen seznam, in potem not dodajal tocke itd.
	public Tocka(String ime) { //to je konstruktor nima tipa pred imenom, ker to ni metoda
		// tu ustvarimo novo izolirano tocko
		this.ime = ime; // isto kot self. v pythonu, to "poklice" zgornjo komponento ime, ime je tudi lokalna spremenljivka, delal bi tud �e bi lokalno spremenljivko druga� poimenoval
		sosedi = new HashSet<Tocka> (); // to je klic konstruktorja
		//Set ni razred je le vmesnik, zato novega objekta Set ne moremo naredit,rabimo implementacijo vmesnika
		//--> HashSet
		//tudi lahko: this.sosedi, �e nimamo 2 isti imeni, raje ne uporabljamo 
	}
	
	public int stopnja () { // to je metoda zato spredaj int ker vra�a integer
		// ne rabimo dat parametra ker bo avtomatsko dala this.
		return sosedi.size();
	}
	
	public String toString() {
		return ime;
	}
	
}
