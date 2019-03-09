import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.math.*;

public class Hitrost {

	public static void main(String[] args) throws IOException{
		int n = prehitriVozniki("src\\podatki.txt", "src\\prehitriVozniki.txt", 80, 622); // 80 km/h je omejitev, dolžina tunela pa 622m
		System.out.println("V datoteki je " + n + " prehitrih voznikov");
	}
	
	public static int prehitriVozniki(String imeVhod, String imeIzhod, int omejitev, int dolzina) throws IOException{
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		int vsota = 0;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);
		df.setRoundingMode(RoundingMode.HALF_UP);
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue;
			String[] podatki = vrstica.split("\\W+");
			int vstopna = Integer.parseInt(podatki[0]);
			int izhodna = Integer.parseInt(podatki[1]);
			double povprecna = dolzina / (izhodna - vstopna) * 3.6;
			if (povprecna > omejitev) {
				vsota += 1;
				izhod.println(podatki[2] + df.format(povprecna));
			}
		}
		vhod.close();
		izhod.close();
		return vsota;
	}

}
