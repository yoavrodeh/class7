public class CopyOf {
	static <T> T[] copyOf(T[] original, int newLength) {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Object[newLength];
		for (int i = 0; i < Math.min(original.length,
				newLength); i++)
			copy[i] = original[i];
		return copy;
	}
	
	static <T> T[] copyOf2(T[] original, int newLength) {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Object[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}
}
