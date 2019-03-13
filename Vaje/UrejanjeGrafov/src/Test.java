
public class Test {

	public static void main(String[] args) {
		Graf graf = Graf.cikel(5);
		graf.izpis();
		
		Graf g = new Graf();
		Tocka a = g.dodajTocko("a");
		Tocka b = g.dodajTocko("b");
		Tocka c = g.dodajTocko("c");
		Tocka d = g.dodajTocko();
		g.dodajPovezavo(a, b);
		g.dodajPovezavo(b, c);
		g.dodajPovezavo(c, d);
		g.izpis();
		
		Graf e = Graf.prazen(5);
		System.out.println(e.povezan());
		System.out.println(graf.povezan());
		
		Graf poln = Graf.poln(5);
		poln.izpis();
		
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true); // naredimo okno vidno
		graf.razporedi(300, 300, 200);
		okno.platno.narisi(graf); // okno je objekt ki vsebuje platno ki ima metodo narisi
		
		
		
	}
}
