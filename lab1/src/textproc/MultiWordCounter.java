package textproc;
import java.util.*;

public class MultiWordCounter implements TextProcessor {
	
	private Map<String, Integer> m = new TreeMap<>(); 
	
	
	public MultiWordCounter( String [] s) {
		for(String landscape : s)
			m.put(landscape, 0);
	}

	@Override
	public void process(String w) {
		 m.computeIfPresent(w, (k, v) -> v + 1);	
			
	}

	@Override
	public void report() {
//		m.forEach((k, v) -> {
//            System.out.format("%s: %d%n", k, v);
//        });
		Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		wordList.sort(new WordCountComparator());
		for (int i = 0; i<20; i++) {
			System.out.format("%s: %d%n",wordList.get(i).getKey().toString(),wordList.get(i).getValue()  );
		}
	}

}
