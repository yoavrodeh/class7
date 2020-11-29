import java.util.ArrayList;
import java.util.List;
public class ArrayListExample {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("one");
		l.add("two");
		l.add("three");
		l.add(1, "four");
		System.out.println(l); // [one, four, two, three]
		l.remove(1);
		for (String s : l)
			System.out.print(s + " "); // one two three
	}
}
