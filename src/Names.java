import java.util.ArrayList;
import java.util.List;

public class Names<E extends HasName> {
	private List<E> elements = new ArrayList<E>();

	public void add(E e) { elements.add(e); }

	public String allNames() {
		StringBuilder b = new StringBuilder();
		for (E e : elements)
			b.append(e.getName() + " ");
		return b.toString();
	}
}
