package textproc;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Map.Entry<String, Integer>> {

	public WordCountComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		
		if (o1.getValue().intValue()< o2.getValue().intValue() ||
				(o1.getValue().intValue() == o2.getValue().intValue() && o1.getKey().toString().compareTo(o2.getKey().toString()) > 0   )
				) {
			return 1;
		}
		
		
		return -1;
		
	}

}
