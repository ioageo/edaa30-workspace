package textproc;
import java.util.*;
import java.util.Map.Entry;

public class GeneralWordCounter implements TextProcessor {
	
	private Map<String, Integer> map = new TreeMap<>();
	private Set<String> exceptions;
	
	public GeneralWordCounter(Set<String> s) {
		exceptions = new HashSet<>();
		for(String index : s)
			exceptions.add(index);
		
	}
	
	public Set<Entry<String, Integer>> getWords() {
		Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
		return wordSet ;
		}

	@Override
	public void process(String w) {
		 if (!w.matches("-?\\d+(\\.\\d+)?") ) {
			 if (!exceptions.contains(w) && map.containsKey(w)) {
				map.computeIfPresent(w, (k, v) -> v + 1);
			}
			else {
				map.put(w, 1);	}	
		 }
		
		
				
	}

	@Override
	public void report() {	

//		map.forEach((k,v) -> {
//			if(v > 200)
//				System.out.format("%s, %d%n", k, v);
//		});
		
		Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		wordList.sort(new WordCountComparator());
		for (int i = 0; i<20; i++) {
			System.out.format("%s: %d%n",wordList.get(i).getKey().toString(),wordList.get(i).getValue()  );
		}
		
//		wordList.sort(Map.Entry.comparingByValue());
//		
//		int pos = 5;
//		
//		for (int k = wordList.size()-1; k >=  wordList.size()- pos ; k--)
//			System.out.format("%s: %d%n",   wordList.get(k).getKey(),wordList.get(k).getValue() );
		
	}

}
