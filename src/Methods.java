public class Methods {
	public static <E> void printArray(E[] array) {
		for (E element : array) 
			System.out.print(element + " ");
		System.out.println();
	}
	
	public static <T1, T2> boolean areEqual(
			Pair<T1, T2> p1, Pair<T1, T2> p2) {
		return p1.get1().equals(p2.get1()) 
				&& p1.get2().equals(p2.get2());
	}
}
