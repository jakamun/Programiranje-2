import java.io.*; // z zvezdico smo uvozil vse razrede ki jih ponuja paket io

public class StetjeBesed {

	public static void main(String[] args) throws IOException{ // preloži napako na že vgrajeno funkcijo
		int n = stetjeBesed("src/StetjeBesed.java", "src/presteteBesede.txt");
		System.out.println("V datoteki je " + n + " besed.");
	}
	
	public static int stetjeBesed(String vhod, String izhod) throws IOException{ // namesto try in catch za zajemanje napak, s tem preložimo reševanje problemov na glavno metodo in rabmo tam rešavat ta problem
		BufferedReader in = new BufferedReader(new FileReader(vhod)); // s tem smo vhodno datoteko oprli za branje
		PrintWriter out = new PrintWriter(new FileWriter(izhod)); // smo ustvarili datoteko za pisanje
		int stevec = 0;
		while (in.ready()) {// ready preveri èe je v vhodni datoteki še kaj ostalo za prebrat 
			String vrstica = in.readLine().trim(); // pobriše bele znake na zaèetku in na koncu vrstice
			if (vrstica.equals("")) continue; // èe je vrstica prazna gre v novo vrstico zato tud ne rabim else
			String[] besede = vrstica.split("\\W+"); // razbije besede vrstice v tabelo, whitespaci so loèila
			stevec += besede.length;
			for (String beseda : besede) out.println(beseda);
		}
		in.close();
		out.close();
		return stevec;
	}

}
