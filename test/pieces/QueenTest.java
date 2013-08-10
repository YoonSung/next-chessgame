package pieces;

import java.util.ArrayList;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	
	Queen queen;
	
	public void testGetPossibleMoves() throws Exception {
		ArrayList<Position> moves = new ArrayList<Position>();
		
		queen = new Queen(Color.BLACK, new Position("h5"));
		moves = (ArrayList<Position>) queen.getPossibleMoves();
		assertEquals(21, moves.size());
		
		queen = new Queen(Color.BLACK, new Position("d4"));
		moves = (ArrayList<Position>) queen.getPossibleMoves();
		assertEquals(27, moves.size());
		
		queen = new Queen(Color.BLACK, new Position("c5"));
		moves = (ArrayList<Position>) queen.getPossibleMoves();
		assertEquals(25, moves.size());
	}
}
