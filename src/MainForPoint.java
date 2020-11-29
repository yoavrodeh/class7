import java.util.ArrayList;
import java.util.List;

public class MainForPoint {
	public static void main(String[] args) {
		List<Point> l = new ArrayList<>();
		l.add(new Point(1, 2));
		l.add(new Point(7, 1));
		System.out.println(l.contains(new Point(1, 2)));
	}
}
