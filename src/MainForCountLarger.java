public class MainForCountLarger {
	public static void main(String[] args) {
		Student2 s1 = new Student2("Bob Sfog", 3);
		Student2 s2 = new Student2("Micky Mouse", 10);
		Student2 s3 = new Student2("Max and Moris", 12);
		Student2[] arr = {s1, s2, s3};
		System.out.println(CountLarger.count(arr, 
				new Student2("", 7))); 
		// 2
	}
}
