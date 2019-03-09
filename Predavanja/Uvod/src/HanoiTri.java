// Import the java.util.Scanner class so we can read from the input
import java.util.Scanner;

public class HanoiTri {
	
	public static void main(String[] args) {
		// Imperative Hanoi with an array
		// Read the number of disks from the input stream
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt(); // v konzolo napišem število diskov in se program izvede
		sc.close();
		// tabele v javi se naredijo tako da napišem tip in oglate oklepaje zraven npr. double[] 
		// tabele se ne dajo veèat ali manšat ko so ustvarjene, lahko pa spreminjamo njihovo vsebino
		// positions[i-1] will be the position of disk i
		int [] positions = new int[n]; // ustvaril smo tabelo velikosti n
		// nastavmo vse diske na 1
		for (int i=0; i<n; i++) {positions[i]=1;};
		// Step through 2^{n-1} moves, glih tok potez rabmo
		int steps = (int) Math.pow(2,n);
		for (int i=1; i < steps; i++) {
			int disk = findDisk(i);
			int direction = (disk+n)%2;
			// Get the current position of disk and change to next position
			int now = positions[disk-1];
			int next = (direction == 0) ? (now%3)+1 : (now+1)%3+1 ;
			positions[disk-1] = next;
			// Print move
			System.out.print("Move disk " + disk);
			if (direction == 0) {System.out.print(" clockwise");}
			else {System.out.print(" anticlockwise");};
			System.out.println(" from " + now + " to " + next);
		}
	}
	
	public static int findDisk (int step) {
		if (step%2 ==1) {return 1;}
		else {return 1 + findDisk(step/2);}
	}

}