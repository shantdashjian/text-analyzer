package project;

import java.io.IOException;

public class TextAnalyzerDriver {

	public static void main(String[] args) throws IOException{
		TextAnalyzer textAnalyzer = new TextAnalyzer(args);
		textAnalyzer.analyzeText();
	}
}
