
public class HanoiEna {

	public static void main(String[] args) {
		// ideja je imam 3 plo��adi na prvi so 3 diski razli�ne velikosti
		// te diske ho�em spravit na drugo plo��ad
		// vendar lahko prestavim en disk naenkrat in ne smem dat ve�ji disk na man�iga 
		// z final sem objekt n fiksiral in bo n skoz 3 tudi �e ga funkcija spreminja bo na koncu �e vedno 3
		final int n = 3; // n je �tevilo diskov
		hanoi(n, 1, 2); // z prve plo��adi na drugo
	}
	
	public static void hanoi(int n, int start, int end) {
		if (n>0) {
			int middle = other(start, end);
			hanoi(n-1, start, middle);
			System.out.println("move disk " + n + " from " + start + " to " + end);
			hanoi(n-1, middle, end);
		}
	}
	
	public static int other(int x, int y) {
		// vsota teh tri �tevil in od�tejem podani �tevili ter tako dobim mankajo�e �tevilo
		// na to plo��ad odlagam za to da pridem do najve�jega diska in ga dam na pravo plo�ad tja kamor ho�em
		return 6 - (x + y);
	}

}
