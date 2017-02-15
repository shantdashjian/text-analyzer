package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextAnalyzer {
	public static String option;
	public static String fileName;

	public static void main(String[] args) throws IOException {
		setOptionAndFileName(args);
		analyzeText(option, fileName);
	}

	public static void setOptionAndFileName(String[] args) {
		if (args.length == 2) {
			option = args[0];
			fileName = args[1];
		} else {
			option = "-a";
			fileName = "usdeclar.txt";
		}
	}

	public static void analyzeText(String option, String fileName) throws IOException {
		switch (option) {
		case "-a":
			System.out.println("No. of lines in file: " + getLineCount(fileName));
			System.out.println("No. of words in file: " + getWordCount(fileName));
			System.out.println("No. of characters in file: " + getCharacterCount(fileName));
			break;
		case "-l":
			System.out.println("No. of lines in file: " + getLineCount(fileName));
			break;
		case "-w":
			System.out.println("No. of words in file: " + getWordCount(fileName));
			break;
		case "-c":
			System.out.println("No. of characters in file: " + getCharacterCount(fileName));
			break;
		default:
			break;
		}
	}

	public static int getCharacterCount(String fileName) throws IOException {
		int count = 0;
		List<String> list = readFileIntoList(fileName);
		for (String line : list) {
			count += line.length();
		}
		return count;

	}

	public static int getWordCount(String fileName) throws IOException {
		int count = 0;
		List<String> list = readFileIntoList(fileName);
		for (String line : list) {
			String[] words = line.split("[ ]");
			count += words.length;
		}
		return count;
	}

	public static int getLineCount(String fileName) throws IOException {
		List<String> list = readFileIntoList(fileName);
		return list.size();
	}

	public static List<String> readFileIntoList(String fileName) throws IOException {
		List<String> list = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			throw e;
		}
		return list;
	}
}
