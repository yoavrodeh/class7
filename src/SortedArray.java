import java.util.ArrayList;
import java.util.List;

public class SortedArray<E extends Comparable<E>> {
	private List<E> a = new ArrayList<>();

	public void add(E e) {
		int i = 0;
		while (i < a.size() && e.compareTo(a.get(i)) >= 0)
			i++;
		a.add(i, e);
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		for (E e : a) {
			b.append(e);
			b.append(" ");
		}
		return b.toString();
	}
}
