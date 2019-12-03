package tests;

import java.util.HashMap;
import java.util.Map;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		System.out.println(map.get("A") + " " + map.size());
		map.put("A", 43);
		System.out.println(map.get("A") + " " + map.size());
		map.put("A", 42);
		System.out.println(map.get("A") + " " + map.size());

	}

}
