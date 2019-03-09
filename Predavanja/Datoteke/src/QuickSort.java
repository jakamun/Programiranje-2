import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		// quicksort uredi tabelo tako da izbere nek pivot v tabeli
		// potem postavi na levo vse elemnte, ki so manši od njega in na desno vse ki so veèji pivot je tako na pravem mestu
		// to se potem rekurzivno izvede na levi strani in desni strani in se tako uredi tabela
		
		Scanner sc = new Scanner(System.in);
		final int velikost = sc.nextInt(); // v konzolo napišem kok velko tabelo hoèm uredit
		sc.close();
		
		//Create a randomly populated array of floats		
		float[] tabela = new float[velikost];		
		Random randoms = new Random();
		for (int i = 0; i < velikost; i++) {
			tabela[i] = randoms.nextFloat();
		}
		
		System.out.println("Before sorting:");
		System.out.println(Arrays.toString(tabela));
		
		//Randomised quicksort the array
		
		rqs(tabela, 0, velikost, randoms);
		
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(tabela));
	}

	// uredim tabelo na intervalu od i do j, z randoms izberem nakljucni pivot
	private static void rqs (float[] array, int i, int j, Random randoms) {
		if (i < j - 1) {
			
			//Choose a random pivot element
			int k = i + randoms.nextInt(j - i);
			
			int p = partition (array, i, k, j);
			rqs (array, i, p, randoms);
			rqs (array, p + 1, j, randoms);
		}
	}

	private static int partition (float[] array, int i, int k, int j) {
		float pval = array[k];
		while (i < j-1) {
			if (array[i] < pval) i++;
			else if (array[j-1] > pval) j--;
			else if (array[i] == pval && array[j-1] == pval) j--;
			else { // swap array[i] and array[j-1]
				float temp = array[j-1];
				array[j-1] = array[i];
				array[i] = temp;
			}
			
		}
		
		return i;
	}

}
