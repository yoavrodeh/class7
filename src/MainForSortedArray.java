public class MainForSortedArray {
	public static void main(String[] args) {
		SortedArray<String> sa = new SortedArray<>();
		sa.add("ccc");
		sa.add("aaa");
		sa.add("zzz");
		sa.add("hhh");
		System.out.println(sa);
		// aaa ccc hhh zzz 
	}
}
