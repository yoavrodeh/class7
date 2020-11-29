import java.util.Arrays;

public class MainForNames {
	public static void main(String[] args) {
		Names<Student> names = new Names<>();
		names.add(new Student("Bor", "Hagibor", 33));
		names.add(new Student("Mor", "Hashikor", 111));
		System.out.println(names.allNames());
		// Bor Hagibor Mor Hashikor 
	}
}
