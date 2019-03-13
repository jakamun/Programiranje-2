import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial") // to rabmo ker swing metoda rabi imet serijsko �tevilko
public class Platno extends JPanel {
	
	int sirina, visina;
	Graf graf;
	
	Color barvaPovezave;
	Color barvaTocke;
	Color barvaRoba;
	Color barvaOzadja;
	double polmer;
	float debelinaPovezave;
	float debelinaRoba;
	
	public Platno (int sirina, int visina) {
		graf = null;
		this.sirina = sirina;
		this.visina = visina;
		barvaPovezave = Color.BLUE; // uporabljamo samo barve z velikimi �rkami
		// v splo�nem je ideja da imajo konstante zapise z velikimi �rkami
		barvaTocke = Color.RED;
		barvaRoba = Color.BLACK; // svojo barvo definira� tako 
		// Color c = new Color (50, 0, 50)
		barvaOzadja = Color.GREEN;
		polmer = 20;
		debelinaPovezave = 2.5f; // f mor� dat na konc ker je float
		debelinaRoba = 1;
	}
	
	public void narisi (Graf g) {
		graf = g;
		repaint(); // ta metoda od sistema izve kaj je Graphics g in potem pokli�e paintComponent
	}
	
	// z override povozimo �e obstoje�o metodo v nadrazredu
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina); // ustvari zecetno velikost platna
	}
	
	// ker je tudi �e ta metoda definirana v JPanel
	@Override
	protected void paintComponent(Graphics g) { // vsaki� ko je treba okno obnovit se pokli�e ta metoda
		super.paintComponent(g); // sedaj smo poklicali �e vgrajeno metodo
		setBackground(barvaOzadja);
		if (graf == null) return; // �e je graf prazen ne narises nicesar
		Graphics2D g2 = (Graphics2D)g; // to zato naredimo da lahko debelino nastavmo, ker Graphics ne pozna debeline
		g.setColor(barvaPovezave); // vse povezave so iste barve
		g2.setStroke(new BasicStroke(debelinaPovezave));
		for (Tocka v : graf.tocke.values()) {
			for (Tocka u : v.sosedi) {
				if (v.ime.compareTo(u.ime) > 0) { // primerjamo imena tock 
					// zato da ne ri�emo nekatrih �rt dvakrat
					g.drawLine(round(v.x), round(v.y), round(u.x), round(u.y));
				}
			}
		}
		
		int premer = round (2 * polmer);
		g2.setStroke(new BasicStroke(debelinaRoba));
		for (Tocka v : graf.tocke.values()) {
			g.setColor(barvaTocke);
			g.fillOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
			g.setColor(barvaRoba);
			g.drawOval(round(v.x - polmer), round(v.y - polmer), premer, premer);
		}
	}
	
	private static int round(double x) {
// ker je to samo privatna metoda je privatna v nobenem drugem razredu je ne bomo rabl,
//static ker ne rabmo dostopa do grafa
		return (int)(x + 0.5);
	}
}
	
