package chess;

import junit.framework.TestCase;

public class HtmlPrintTest extends TestCase {
	public void testPrintHtml() throws Exception {
		Board board = Board.getInstance();
		board.initialize();
		board.generateBoardInHtml();
	}
}
