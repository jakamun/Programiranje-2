import java.util.*;

public class Graf {
	// ima dve komponenti stevec in pa slovar vseh toèk ki so v grafu
	// kako je graf povezan zvemo iz komponent tock, "sosedov"
	
	int stevec;
	
	Map<String, Tocka> tocke; // Map pomeni slovar, kjer je kot kljuc string in vrednost neka tocka grafa
	
	public Graf () {// konstruktor ki ustvari prazen graf
		stevec = 0; // to je komponenta zgoraj "definirana"
		tocke = new HashMap<String, Tocka> ();
	}
	
	public Tocka tocka(String ime) { // preveri èe toèka v grafu
		return tocke.get(ime); // èe toèke ni notr vrne None
	}
	
	public boolean povezava(Tocka a, Tocka b) { 
		return a.sosedi.contains(b); // vrne true ali falls èe sta toèki povezani
	}
	
	public Tocka dodajTocko(String ime) {
		Tocka v = tocka(ime); // vrne tocko v grafu, èe je ni vrne null
		if (v == null) { // èe je toèka že v grafu ne nardimo niè
			v = new Tocka(ime); // ustvarim novo tocko
			tocke.put(ime, v); // v slovar dodamo tocko
		}
		return v; 
	}
	
	public Tocka dodajTocko() { // ta si sam izmisli tocko in jo doda v graf
		while (true) {
			String ime = Integer.toString(++stevec);
			if (tocka(ime) != null) continue;
			Tocka v = new Tocka(ime);
			tocke.put(ime, v);
			return v;
		}
	}
		
	public void dodajPovezavo (Tocka a, Tocka b) {
		if (a != b) {// ti dve tocki sta ze v grafu vendar nista povezani
			a.sosedi.add(b);
			b.sosedi.add(a);
		}
		else return;
	}
	
	public void odstraniPovezavo (Tocka a, Tocka b) {
		a.sosedi.remove(b);
		b.sosedi.remove(a);
	}
	
	public void odstraniTocko (Tocka a) {
		for (Tocka sosed : a.sosedi) {
			a.sosedi.remove(sosed);
		}
		tocke.remove(a.ime);
	}
	
	public Tocka[] dodajTocke (int n) { // želim dodati n izoliranih tock v graf, vrnem tabelo novih tock
		Tocka[] tabela = new Tocka[n]; // ustvarim tabelo velikosti n
		for (int i = 0; i < n; ++i) {
			tabela[i] = dodajTocko();
		}
		return tabela;
	}
	
	// tu bojo sedaj 4 statiène metode
	// statiène metode ne morejo uporabljati ostalih metod in obratno, lahko jo pa poklièemo na razredu
	// V obratnem primeru bi morali ustvariti nov objekt in na njem poklicati metodo (lahko bomo: Graf.cikel(5))
	
	public static Graf prazen (int n) {
		Graf graf = new Graf();
		graf.dodajTocke(n); // èe bi dal brez graf spredaj, bi razumel kot this.
		return graf;
	}
	
	public static Graf cikel (int n) {
		Graf graf = new Graf ();
		Tocka[] tabela = graf.dodajTocke(n);
		for (int i = 0; i < n; ++i) graf.dodajPovezavo(tabela[i], tabela[(i + 1) % n]); // skoz boš dobivol ostanek (i+1) razn ko bo i+1=n potem pa 0 in se ravno cikel naredi
		return graf;
	}
	
	public static Graf poln (int n) {
		Graf graf = new Graf();
		Tocka[] tocke = graf.dodajTocke(n);
		for (int i=0; i < n; ++i) {
			for (int j=i+1; j < n; j++) {
				graf.dodajPovezavo(tocke[i], tocke[j]);
			}
		}
		return graf;
	}
	
	public static Graf polnDvodeln(int n, int m) {
		Graf graf = new Graf ();
		Tocka[] tocke1 =  graf.dodajTocke(n);
		Tocka[] tocke2 =  graf.dodajTocke(m);
		for  (int i = 0; i < n; ++i) {
			for (int k = 0; k < m; ++k) {
				graf.dodajPovezavo(tocke1[i], tocke2[k]); // vsaka toèka iz prvega dela grafa povezana z vsako toèko iz drugega dela grafa
			}
		}
		return graf;
	}
	
	public void izpis() {
		for (Tocka i : tocke.values()) {
			System.out.print("V grafu je tocka " + i + " z sosedi: ");
			for (Tocka j : i.sosedi) {
				System.out.print(j + ", ");
			}
			System.out.println();
		}
	}
	
	public boolean povezan() { // to ni prov
		for (Tocka i : tocke.values()) {
			if (i.stopnja() == 0) return false; // èe je stopnja enaka 0 potem je ta toèka izolirana in graf ni povezan
		}
		return true;
	}
	
	public void razporedi(double x, double y, double r) {
		int n = tocke.size(); // število toèk
		int i = 0; // z i hodimo po vseh tockah
		for (Tocka v : tocke.values()) { // èe seznam prazen se for zanka ne izvede
			double kot = (2*i*Math.PI)/n; // da enakomerno razporedimo morjo bit koti skoz enaki
			v.x = x + r*Math.cos(kot); // vsaki toèki bomo posebaj doloèili x in y komponento tako da bojo enakomerno razporejene
			v.y = y + r*Math.sin(kot);
			++i;
		}
	}
	
}
