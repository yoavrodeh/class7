package exercise;

import java.util.ArrayList;
import java.util.List;

public class MyMap2<K, V> {
	private List<Pair<K,V>> l = new ArrayList<>();

	public void put(K key, V value) {
		l.add(new Pair<>(key, value));
	}
	
	public V get(K key) {
		int i = l.indexOf(new Pair<>(key, null));
		return l.get(i).get2();
	}
}
