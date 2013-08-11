package chess;

import junit.framework.TestCase;

public class ConsolePrintTest extends TestCase {
	public void testPrintConsole() throws Exception {
		Board board = new Board();
		board.initialize();
		board.generateBoardInConsole();
	}
}
