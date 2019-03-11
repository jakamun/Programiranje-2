package myholders;

import java.util.ArrayList;

public abstract class MyHolder<E> {

	// tu samo definiramo seznam oz. holder
	// in na�in kako se notr daje elemente, ker je za to skoz ista metoda
	
	protected ArrayList<E> holder; // ne damo ne private in ne public ker ho�mo da je vidn v podrazredih, vendar ne pa kr nekje drugje
	// �e damo protected lahko ta holder uporablajo razredi in podrazredi znotraj tega paketa
	
	public MyHolder() {
		holder = new ArrayList<E> (); // naredimo prazen seznam
	}
	
	public void put (E val) {
		holder.add(0, val); // mor� dat 0 da postavi nov element na za�etek druga�e ga postavi na konec
	}
	
	public abstract E take (); // z tem sem v superclass dal metodo take vendar, s tem prisilim subclasse da morjo met definirano metodo take, druga�e javi napako

}
