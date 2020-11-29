public class Point extends OrderedPair<Integer, Integer> {
	public Point(int t1, int t2) {
		super(t1, t2);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Point))
			return false;
		Point o = (Point) other;
		return get1().equals(o.get1())
				&& get2().equals(o.get2());
	}
}
