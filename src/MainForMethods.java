public class MainForMethods {
	public static void main(String[] args) {
		String[] arr = {"ab", "cd", "ef"};
		Methods.<String>printArray(arr);
		
		Pair<Integer, String> p1 = 
				new OrderedPair<>(1, "apple");
		Pair<Integer, String> p2 = 
				new OrderedPair<>(2, "pear");
		boolean same = 
				Methods.<Integer, String>areEqual(p1, p2);

		Methods.printArray(arr);
		boolean same2 = Methods.areEqual(p1, p2);
	}
}
