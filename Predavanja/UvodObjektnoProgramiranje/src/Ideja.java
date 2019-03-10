import java.util.ArrayList;

// HOLDERS
// imamo vreèo v katerega dajemo elemente in jih vzemamo ven na veè možnih naèinov
// Stack - Last in First out (LIFO)
// Queue - First in First out (FIFO)
// Urn - vzame vn nakljuèni element

// lahko bi kle notr vse tri metode definiral, lahko pa naredimo nek nadrazred
// kjer definiramo seznam in metodo vzemanja ven, ker je skoz ista
// in potem podrazrede za vsak naèin vzemanja ven en podrazred
// vse skupaj imamo znotraj nekega paketa
// ta paket lahko uporabljamo v drugih razredih tako da ga importamo

public class Ideja<E> { // z tem smo povedal da deluje za poljuben tip èe bi dal <Integer> bi bil ta razred tipa Integer

	// tuki sem naredil samo za stack 
	// tu ni neke glavne metode kjer bi ostale metode uporabil, ker to naredim v glavnem razredu
	
	// definiramo sezname poljubnega tipa, to ne pomeni da imamo lahko razliène tipe v seznamu èe mamo int je pol vse int
	private ArrayList<E> stack; // private pomeni da ta seznam ni viden zunaj tega razreda  
	
	public Ideja () {
		stack = new ArrayList<E> ();
	}
	
	public void put (E val) {
		stack.add(0, val); // skoz dajemo nove elemnte na prvo mesto
	}
	
	public E take () {
		// izpustim primer da je seznam prazen
		E val = stack.get(0);
		stack.remove(0);
		return val;
	}

}
