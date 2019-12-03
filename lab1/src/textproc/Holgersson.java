package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		List<TextProcessor> nameList = new ArrayList<>();
		Set<String> exceptionWords = new HashSet<>();
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		while(scan.hasNext())
		{
			exceptionWords.add(scan.next().toLowerCase());
		}
		scan.close();
		nameList.add(new MultiWordCounter(REGIONS));
		nameList.add(new SingleWordCounter("norge"));
		nameList.add(new SingleWordCounter("nils"));
		nameList.add(new GeneralWordCounter(exceptionWords));
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for(TextProcessor i : nameList)
			i.process(word);
		}

		s.close();
		for(TextProcessor i : nameList)
			i.report();
		
		
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}