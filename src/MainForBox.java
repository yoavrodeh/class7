public class MainForBox {
    public static void main(String[] args) {
    	Box<String> b = new Box<String>();
    	b.set("Good morning!");
    	Box<Integer> b2 = new Box<Integer>();
    	b2.set(10);
    	System.out.format("%s %d%n", b.get(), b2.get());
    	// Good morning! 10
    }
}
