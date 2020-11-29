public class MainForMyArray {
	public static void main(String[] args) {
		MyArray<String> a = new MyArray<>();
		for (int i = 0; i < 100; i++)
			a.add("E" + i);
		System.out.format("%d, %s, %d%n",
				a.length(), a.get(79), a.indexOf("E14"));
		// 100, E79, 14
	}
}
