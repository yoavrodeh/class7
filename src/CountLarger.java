public class CountLarger {
	public static <E extends Comparable<E>> int count(
			E[] arr, E e) {
		int count = 0;
		for (E e2 : arr)
			if (e.compareTo(e2) < 0)
				count++;
		return count;
	}
}
