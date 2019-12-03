package map;



public class main_test {

	public static void main(String[] args) {
		Map<Integer, Integer> i;
		Map<String, Integer> s;
		i = new SimpleHashMap<Integer, Integer>();
		s = new SimpleHashMap<String, Integer>();
		
//		int j=10;
//		
//		for(int k=0;k<j;k++) {
//			i.put(k, k);
//		}
		i.put(1, 1);
		i.put(17, 17);
		i.put(33, 33);
		i.put(49, 49);
		i.put(65,  65);
		i.show(); 
		
		System.out.println("remove 65 " +  i.remove(65)); // first or last
		System.out.println("remove 1 "+ i.remove(1));   // last or first
		System.out.println("remove 33 "+ i.remove(33)); // middle
		System.out.println("remove 49 "+ i.remove(49)); 
		System.out.println("remove 17 "+ i.remove(17)); 
//		System.out.println("size():"+ 7+" "+ i.size());
		
		System.out.println();
		
		i.show(); 
		
		System.out.println(i.get(78));
		
		
		
		
	}

}
