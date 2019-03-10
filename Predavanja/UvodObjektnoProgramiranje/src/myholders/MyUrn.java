package myholders;

import java.util.Random;

public class MyUrn<E> extends MyHolder<E> {
	
	// nakljuèno si nek element izberemo in ga odstranimo
	
	private Random randoms = new Random();
	
	public E take () {
		int size = holder.size();
		int index = randoms.nextInt(size);
		E val = holder.get(index);
		holder.remove(index);
		return val;
	}
	
}
