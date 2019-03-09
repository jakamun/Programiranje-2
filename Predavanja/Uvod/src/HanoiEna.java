
public class HanoiEna {

	public static void main(String[] args) {
		// ideja je imam 3 plošèadi na prvi so 3 diski razliène velikosti
		// te diske hoèem spravit na drugo plošèad
		// vendar lahko prestavim en disk naenkrat in ne smem dat veèji disk na manšiga 
		// z final sem objekt n fiksiral in bo n skoz 3 tudi èe ga funkcija spreminja bo na koncu še vedno 3
		final int n = 3; // n je število diskov
		hanoi(n, 1, 2); // z prve plošèadi na drugo
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
		// vsota teh tri števil in odštejem podani števili ter tako dobim mankajoèe število
		// na to plošèad odlagam za to da pridem do najveèjega diska in ga dam na pravo plošad tja kamor hoèem
		return 6 - (x + y);
	}

}
