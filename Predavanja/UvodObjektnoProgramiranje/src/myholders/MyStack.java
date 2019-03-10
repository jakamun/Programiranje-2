package myholders;

public class MyStack<E> extends MyHolder<E> { // tako naredil podrazred od MyHoldersov

	// to je naèin vzemanja ven Last in First out iz seznama
	
	public E take () {
		E val = holder.get(0);
		holder.remove(0);
		return val;
	}

}
