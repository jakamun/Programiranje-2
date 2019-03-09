import java.util.Random;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		final int size = 6;
		
		//Create a randomly populated array of floats		
		float[] nums = new float[size];		
		Random randoms = new Random();
		for (int i = 0; i<size; i++) {
			nums[i] = randoms.nextFloat();
		}
		
		System.out.println("Before sorting:");
		System.out.println(Arrays.toString(nums));
		
		//Randomised quicksort the array
		
		rqs(nums,0,size, randoms);
		
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(nums));
	}

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
			if (array[i] < pval) {i++;}
			else if (array[j-1] > pval) {j--;}
			else if (array[i] == pval && array[j-1] == pval) {j--;}
			else { // swap array[i] and array[j-1]
				float temp = array[j-1];
				array[j-1] = array[i];
				array[i] = temp;
			}
			
		}
		
		return i;
	}

}
