public class StrIntPair implements Pair<String, Integer> {
	private String s;
	private int i;
	
	public StrIntPair(String s, int i) {
		this.s = s;
		this.i = i;
	}
	@Override
	public String get1() { return s; }
	@Override
	public Integer get2() { return i; }
}
