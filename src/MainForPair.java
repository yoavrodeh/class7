public class MainForPair {
	public static void example() {
		Pair<String, Integer> p1 = 
			new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String>  p2 = 
			new OrderedPair<String, String>("hello", "world");
		Pair<String,String> p3 = 
			new OrderedPair<>("oh my", "god");
		Pair<String, Box<Integer>> p = 
			new OrderedPair<>("abc", new Box<>());
	}
}
