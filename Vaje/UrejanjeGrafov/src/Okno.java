import javax.swing.*;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	// rabimo neko okno kamor se bo to platno izpisalo
	// to okno dejansko poženemo v testu
	Platno platno;
	
	public Okno() {
		super();
		setTitle("Urejevalnik grafov");
		platno = new Platno(600, 600);
		add(platno); // s tem smo platno dodali v okno
	}
	
}
