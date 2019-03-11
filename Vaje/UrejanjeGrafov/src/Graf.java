import java.util.*;

public class Graf {
	
	int stevec;
	Map<String, Tocka> tocke; // Map pomeni slovar, kjer je kot kljuc string in vrednost neka tocka grafa
	
	public Graf () {// konstruktor ki ustvari prazen graf
		stevec = 0; // to je komponenta zgoraj "definirana"
		tocke = new HashMap<String, Tocka> ();
	}
	
	public Tocka tocka(String ime) {
		return tocke.get(ime); // �e to�ke ni notr vrne None
	}
	
	public boolean povezava(Tocka a, Tocka b) { 
		return a.sosedi.contains(b); // vrne true ali falls �e sta to�ki povezani
	}
	
	public Tocka dodajTocko(String ime) {
		Tocka v = tocka(ime); // vrne tocko v grafu, �e je ni vrne null
		if (v == null) { // �e je to�ka �e v grafu ne nardimo ni�
			v = new Tocka(ime); // ustvarim novo tocko
			tocke.put(ime, v); // v slovar dodamo tocko
		}
		return v; 
	}
	
	public Tocka dodajTocka() { // ta si sam izmisli tocko in jo doda v graf
		while (true) {
			String ime = Integer.toString(++stevec);
			if (tocka(ime) != null) continue;
			Tocka v = new Tocka(ime);
			tocke.put(ime, v);
			return v;
		}
		
		
		
	}
	
}
