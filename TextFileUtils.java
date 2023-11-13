package Task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.w3c.dom.Text;


public class TextFileUtils {
	public static final String fileName = "D:\\aaa\\WorkSpace_21\\TH_NLU_TH8\\src\\Task2\\short.txt";
	// read the content of a text file
//	String filePath = "D:\\aaa\\WorkSpace_21\\TH_NLU_TH8\\src\\Task2";
	public static void readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
//			tách các từ trong câu ra dựa và dấu cách
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken());
			}
		}
		reader.close();
	}

	public static void main(String[] args) {
//		try {
//			readText("D:\\aaa\\WorkSpace_21\\TH_NLU_TH8\\src\\Task2\\short.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		List<String> words = new ArrayList<String>();
		TextAnalyzer TextAnalyzer = new TextAnalyzer(words);
		try {
			TextAnalyzer.load(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("mostFrequentWord: " + TextAnalyzer.mostFrequentWord());
		TextAnalyzer.displayWords();
		TextAnalyzer.displayText();
		
	}
}
