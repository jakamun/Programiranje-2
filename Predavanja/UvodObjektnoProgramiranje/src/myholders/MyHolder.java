package myholders;

import java.util.ArrayList;

public class MyHolder<E> {

	// tu samo definiramo seznam oz. holder
	// in naèin kako se notr daje elemente, ker je za to skoz ista metoda
	
	ArrayList<E> holder; // ne damo ne private in ne public ker hoèmo da je vidn v podrazredih, vendar ne pa kr nekje drugje
	
	public MyHolder() {
		holder = new ArrayList<E> (); // naredimo prazen seznam
	}
	
	public void put (E val) {
		holder.add(0, val); // morš dat 0 da postavi nov element na zaèetek drugaèe ga postavi na konec
	}

}
