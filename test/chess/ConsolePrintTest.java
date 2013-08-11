package chess;

import junit.framework.TestCase;

public class ConsolePrintTest extends TestCase {
	public void testPrintConsole() throws Exception {
		Board board = Board.getInstance();
		board.initialize();
		board.generateBoardInConsole();
	}
}
