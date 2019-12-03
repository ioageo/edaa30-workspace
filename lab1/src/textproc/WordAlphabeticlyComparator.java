package textproc;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class WordAlphabeticlyComparator implements Comparator<Map.Entry<String, Integer>> {

	public WordAlphabeticlyComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

		if (o1.toString().compareTo(o2.getKey().toString()) > 0
				|| (o1.getKey().toString().equals(o2.getKey().toString())
						&& o1.getValue().intValue() > o2.getValue().intValue())) {
			return 1;
		}

		return -1;
	}

}
