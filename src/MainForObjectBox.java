public class MainForObjectBox {
	public static void main(String[] args) {
		ObjectBox b = new ObjectBox();
		b.set("Good morning!");
		String g = (String)b.get();
	}
}
