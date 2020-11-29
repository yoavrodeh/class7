public class Student implements HasName {
	private String firstName, lastName;
	private long id;
	public Student(String firstName, String lastName,
			long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	@Override
	public String getName() {
		return firstName + " " + lastName;
	}
}