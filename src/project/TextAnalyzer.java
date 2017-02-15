package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextAnalyzer {
	private String option;
	private String fileName;

	public TextAnalyzer() {
		option = "-a";
		fileName = "usdeclar.txt";
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public TextAnalyzer(String[] args) {
		this();
		if (args.length == 2) {
			option = args[0];
			fileName = args[1];
		}
	}

	public void analyzeText() throws IOException {
		switch (option) {
		case "-a":
			System.out.println("No. of lines in file: " + getLineCount());
			System.out.println("No. of words in file: " + getWordCount());
			System.out.println("No. of characters in file: " + getCharacterCount());
			break;
		case "-l":
			System.out.println("No. of lines in file: " + getLineCount());
			break;
		case "-w":
			System.out.println("No. of words in file: " + getWordCount());
			break;
		case "-c":
			System.out.println("No. of characters in file: " + getCharacterCount());
			break;
		default:
			break;
		}
	}

	public int getCharacterCount() throws IOException {
		int count = 0;
		List<String> list = readFileIntoList();
		for (String line : list) {
			count += line.length();
		}
		return count;

	}

	public int getWordCount() throws IOException {
		int count = 0;
		List<String> list = readFileIntoList();
		Pattern pattern = Pattern.compile("[ ]");
		for (String line : list) {
			String[] words = pattern.split(line);
			count += words.length;
		}
		return count;
	}

	public int getLineCount() throws IOException {
		List<String> list = readFileIntoList();
		return list.size();
	}

	public List<String> readFileIntoList() throws IOException {
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
