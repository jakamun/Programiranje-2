
public class Poudarjanje {

	public static void main(String[] args) {
		System.out.println(poudari("Zadnja novica"));
		System.out.println(delnoPoudari("Zadnja *novica* danes!"));
	}
	
	public static String poudari(String niz) {
		String nov = "";
		for (int i = 0; i < niz.length(); i++) {
			char znak = niz.charAt(i);
			if (i != 0) nov += " ";
			nov += Character.toUpperCase(znak);
		}
		return nov;
	}
	
	public static String delnoPoudari(String niz) {
		String nov = "";
		boolean zvezdica = false;
		for (int i = 0; i < niz.length(); i++) {
			char znak = niz.charAt(i);
			if (znak == '*') zvezdica = !zvezdica;
			else if (zvezdica) nov += Character.toUpperCase(znak);
			else nov += znak;
		}
		return nov;
	}

}
