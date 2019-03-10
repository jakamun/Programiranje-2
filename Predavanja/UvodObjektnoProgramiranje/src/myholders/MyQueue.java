package myholders;

public class MyQueue<E> extends MyHolder<E> {
	
	// deluje po principu first in first out
	
	public E take () {
		int size = holder.size();
		E val = holder.get(size-1); // ne deluje èe daš -1, da bi dobil zadnjega
		holder.remove(size-1);
		return val;
	}
	
}

