
public class Collatz {

	public static void main(String[] args) {
		System.out.println(dolzina(6));
		System.out.println(najvecji(6));
		izpis(6);
	}
	
	public static int dolzina(int n) {
		int len = 1;
		while (n != 1) {
			if (n%2 == 0) n = n / 2;
			else n = n * 3 + 1;
			++len;
		}
		return len;
	}
	
	public static int najvecji(int n) {
		int max = n;
		while (n != 1) {
			if (n%2 == 0) n = n / 2;
			else n = n * 3 + 1;
			if (max < n) max = n;
		}
		return max;
	}
	
	public static void izpis(int n) {
		System.out.print(n);
		while (n != 1) {
			if (n%2 == 0) n = n / 2;
			else n = n * 3 + 1;
			System.out.print(" " + n);
		}
	}

}
