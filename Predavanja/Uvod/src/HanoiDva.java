
public class HanoiDva {

	public static void main(String[] args) {
		// re�eno z zankami
		// predpostavim da imam 3 plo��adi
		final int n = 4;
		hanoi(n, 1, 2);
	}
	
	public static void hanoi(int n, int start, int end) {
		int steviloKorakov = (int) Math.pow(2, n); // to je ubistvu 2^n
		for (int korak=1; korak < steviloKorakov; ++korak) {
			int disk = findDisk(korak);
			int direction = (disk+n)%2; // �e je vsota trenutnega diska in �tevila diskov soda gre� clockwise
			System.out.print("Move disk " + disk);
			if (direction == 0) System.out.println(" clockwise");
			else System.out.println(" anticlockwise");
		}
	}
	
	public static int findDisk(int a) {
		if (a%2 == 1) return 1;
		else return 1 + findDisk(a/2);
	}

}
