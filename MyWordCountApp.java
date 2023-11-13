package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "D:\\aaa\\WorkSpace_21\\TH_NLU_TH8\\src\\Task1\\fit.txt";
	// <word, its occurences>
	private List<String> words = new ArrayList<String>();

	public MyWordCountApp(List<String> words) {
		this.words = words;
	}
	public MyWordCountApp() {
		loadData();
	}

	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
//		for (Map.Entry<String, Integer> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue() );
//		}

	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
//		int count = 0;
//		for (Map.Entry<String, Integer> entry : map.entrySet()) {
//			if (entry.getValue() == 1) {
//				count++;
//			}
//		}
//		return count;
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				list.add(entry.getKey());
			}

		}
		for (String word : list) {
			System.out.print(word + " ");
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> mapSorted = new TreeMap<String, Integer>();
		mapSorted.putAll(map);
		for (Map.Entry<String, Integer> entry : mapSorted.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());

		}
	}
}
