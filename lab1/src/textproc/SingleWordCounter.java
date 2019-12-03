package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		if (w.compareTo(word) == 0) {
			n++;
		}
	}

	public void report() {
		System.out.format("%s: %d%n",word, n);
	}

}
