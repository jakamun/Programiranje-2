import myholders.*;

public class UporabaPaketa {

	public static void main(String[] args) {
		
		MyUrn<Integer> sez1 = new MyUrn<Integer> ();
		
		sez1.put(3);
		sez1.put(4);
		sez1.put(5);
		
		System.out.println(sez1.take());
		
		MyQueue<Integer> sez2 = new MyQueue<Integer> ();
		
		sez2.put(3);
		sez2.put(4);
		
		System.out.println(sez2.take());
		
		MyStack<String> sez3 = new MyStack<String> ();
		
		sez3.put("Zdravo");
		sez3.put("Živjo");
		
		System.out.println(sez3.take());
		System.out.println(sez3.take());
		
	}

}
