package exercise;

public class Ex1 {
	public static <E> E printMostCommon(E[] arr) {
		E mostCommon = null;
		int most = -1;
		for (E e : arr) {
			int count = 0;
			for (E e2 : arr) 
				if (e.equals(e2))
					count++;
			if (count > most) {
				most = count;
				mostCommon = e;
			}
		}
		return mostCommon;
	}
	
	public static void main(String[] args) {
		String[] arr = {"one", "one", "two", "one", 
				"three", "three", "two", "three", "three" };
		System.out.println(printMostCommon(arr));
	}
}
