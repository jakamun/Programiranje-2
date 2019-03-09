
public class Razcep {

	public static void main(String[] args) {
		razcep(1024);
		razcep(5761665);
		razcep(60);
		razcep(25);
		razcep(125);
		razcep(113);
	}
	
	public static void razcep(int n) {
		char op = '='; // characterje vedno v enojne narekovaje, stringe pa v dvojne
		System.out.print(n);
		for (int i=2; i*i <= n; i++) {
			int e = 0;
			while (n % i == 0) {
				n = n / i;
				++e;
			}
			if (e > 0) {
				System.out.print(" " + op + " " + i);
				if (e > 1) System.out.print("^" + e);
				op = '*';
			}
		}
		if (n > 1) System.out.print(" " + op + " " + n);
		System.out.println();
	}

}
