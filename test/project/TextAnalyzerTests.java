package project;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextAnalyzerTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_getLineCount_test_file_should_return_3() throws IOException {
		String fileName = "text3lines18words99characters.txt";
		int expectedOutcome = 3;
		assertEquals(expectedOutcome, TextAnalyzer.getLineCount(fileName));
	}

	@Test
	public void test_getWordCount_test_file_should_return_18() throws IOException {
		String fileName = "text3lines18words99characters.txt";
		int expectedOutcome = 18;
		assertEquals(expectedOutcome, TextAnalyzer.getWordCount(fileName));
	}

	@Test
	public void test_getCharacterCount_test_file_should_return_99() throws IOException {
		String fileName = "text3lines18words99characters.txt";
		int expectedOutcome = 99;
		assertEquals(expectedOutcome, TextAnalyzer.getCharacterCount(fileName));
	}
	@Test
	public void test_readFileIntoList_returns_3() throws IOException {
		String fileName = "text3lines18words99characters.txt";
		int expectedOutcome = 3;
		assertEquals(expectedOutcome, TextAnalyzer.readFileIntoList(fileName).size());
	}

	@Test (expected = IOException.class)
	public void test_readFileIntoList_file_not_found_throws_IOException() throws IOException {
		String fileName = "notFoundFile.txt";
		TextAnalyzer.readFileIntoList(fileName);
	}

	@Test (expected = IOException.class)
	public void test_getCharacterCount_file_not_found_throws_IOException() throws IOException {
		String fileName = "notFoundFile.txt";
		TextAnalyzer.getCharacterCount(fileName);
	}
}
