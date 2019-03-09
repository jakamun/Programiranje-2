
public class Ena {

	// opis problema
	// hoèem prvih n èlenov zaporedja, ki je podan na sledeè naèin
	// "1" imamo eno enko torej zapišemo "11" sedaj sta dve enki "21" sedaj ena dvojka in ena enka "1211"
	public static void main(String[] args) {
		String[] t = zaporedje(20);
		for (int i=0; i<t.length; ++i) System.out.println(t[i]);
	}
	
	// tu je String[] kot tabela brez ogljatih oklepajev pa je kot niz
	public static String[] zaporedje(int n) {
		if (n<=0) return new String[0];
		String[] zap = new String[n];
		zap[0] = "1";
		for (int i = 1; i < n; ++i) {
			String prejsni = zap[i - 1];
			String nov = "";
			int j = 0;
			while (j < prejsni.length()) {
				char znak = prejsni.charAt(j);
				int k = j;
				int ponovitve = 0;
				while(k < prejsni.length() && znak == prejsni.charAt(k)) {
					++ponovitve;
					++k;
				}
				nov += "" + ponovitve + znak;
				j = k;
			}
			zap[i] = nov;
		}
		return zap;
	}

}
