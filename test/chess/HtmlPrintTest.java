package chess;

import junit.framework.TestCase;

public class HtmlPrintTest extends TestCase {
	public void testPrintHtml() throws Exception {
		Board board = new Board();
		board.initialize();
		board.generateBoardInHtml();
	}
}
