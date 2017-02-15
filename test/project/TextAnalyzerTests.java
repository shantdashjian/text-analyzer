package project;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextAnalyzerTests {
	private TextAnalyzer textAnalyzer;

	@Before
	public void setUp() throws Exception {
		textAnalyzer = new TextAnalyzer();
	}

	@After
	public void tearDown() throws Exception {
		textAnalyzer = null;
	}

	@Test
	public void test_getLineCount_test_file_should_return_3() throws IOException {
		textAnalyzer.setFileName("text3lines18words99characters.txt");
		int expectedOutcome = 3;
		assertEquals(expectedOutcome, textAnalyzer.getLineCount());
	}

	@Test
	public void test_getWordCount_test_file_should_return_18() throws IOException {
		textAnalyzer.setFileName("text3lines18words99characters.txt");
		int expectedOutcome = 18;
		assertEquals(expectedOutcome, textAnalyzer.getWordCount());
	}

	@Test
	public void test_getCharacterCount_test_file_should_return_99() throws IOException {
		textAnalyzer.setFileName("text3lines18words99characters.txt");
		int expectedOutcome = 99;
		assertEquals(expectedOutcome, textAnalyzer.getCharacterCount());
	}
	@Test
	public void test_readFileIntoList_returns_3() throws IOException {
		textAnalyzer.setFileName("text3lines18words99characters.txt");
		int expectedOutcome = 3;
		assertEquals(expectedOutcome, textAnalyzer.readFileIntoList().size());
	}

	@Test (expected = IOException.class)
	public void test_readFileIntoList_file_not_found_throws_IOException() throws IOException {
		textAnalyzer.setFileName("nonExistentFile.txt");
		textAnalyzer.readFileIntoList();
	}

	@Test (expected = IOException.class)
	public void test_getCharacterCount_file_not_found_throws_IOException() throws IOException {
		textAnalyzer.setFileName("nonExistentFile.txt");
		textAnalyzer.getCharacterCount();
	}
}
