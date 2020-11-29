public class Student2 implements Comparable<Student2> {
	private String name;
	private long id;
	public Student2(String name, long id) {
		this.name = name;
		this.id = id;
	}	
	@Override
	public int compareTo(Student2 other) {
		return id == other.id ? 0 : 
			id > other.id ? 1 : -1;
	}
}
