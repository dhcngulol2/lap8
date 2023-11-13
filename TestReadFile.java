package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		List<String> listWord = new ArrayList<String>();
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("D:\\aaa\\WorkSpace_21\\TH_NLU_TH8\\src\\Task1\\fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			listWord.add(word);
//			System.out.print(word + " ");
		}

		MyWordCountApp wordCount = new MyWordCountApp(listWord);
		wordCount.loadData();
		
//		System.out.println(wordCount.countUnique());
//		wordCount.printWordCounts();
//		System.out.println();
		wordCount.printWordCountsAlphabet();
	}
}