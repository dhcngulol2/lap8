package Task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import javax.xml.validation.Validator;

import Task1.TestReadFile;

public class TextAnalyzer {

	// <word, its positions>
	List<String> words = new ArrayList<String>();
	int count = 0;
	List<Integer> listIndex = new ArrayList<Integer>();
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

//	TestReadFile input = new TestReadFile();

//	public TextAnalyzer() {
//		try {
//			this.words.addAll();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public TextAnalyzer(List<String> words) {
		super();
		this.words = words;
	}

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
//			tách các từ trong câu ra dựa và dấu cách
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(word, -index);
				} else {
					add(word, index);
				}
				index++;
			}
		}
		System.out.println(map);
		r.close();

	}

	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file
	public void add(String word, int position) {
		if (map.containsKey(word)) {
//				ArrayList<Integer> listValue = map.get(word);
//				listValue.add(position);
			map.get(word).add(position);
		} else {
			ArrayList<Integer> listValue = new ArrayList<Integer>();
			listValue.add(position);
			map.put(word, listValue);
		}

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	int sizeWords = 0;
	public void displayWords() {
		Comparator<String> byWord = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		List<String> sort = new ArrayList<String>();
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1) {
				sort.add(entry.getKey() + "= " + entry.getValue().get(0));
			} else {
				for (Integer position : entry.getValue()) {
					sort.add(entry.getKey() + "= " + position);
				}
			}
		}
		sizeWords = sort.size();
		sort.sort(byWord);
		System.out.println(sort);
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		List<String> result = new ArrayList<String>();
		for (int index = 0; index < sizeWords; index++) {
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				for (Integer position : entry.getValue()) {
					if (position < 0 && (Math.abs(position) == index)) {
						result.add(entry.getKey() + "\n");
					}
					if ((position > 0) && Math.abs(position) == index) {
						result.add(entry.getKey());
					}
				}

			}
		}

		for (String word : result) {
			System.out.print(" " + word);
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int maxSize = 1;
		String result = null;
		for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > maxSize) {
				maxSize = entry.getValue().size();
				result = entry.getKey();
			}
		}
		return result;
	}

}
