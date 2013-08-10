package pieces;

import java.util.ArrayList;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class BishopTest extends TestCase {
	
	Bishop bishop;
	
	public void testGetPossibleMoves() throws Exception {
		
		ArrayList<Position> moves = new ArrayList<Position>();
		
		bishop = new Bishop(Color.BLACK, new Position("e3"));
		moves = (ArrayList<Position>) bishop.getPossibleMoves();
		assertEquals(11, moves.size());
		
		bishop = new Bishop(Color.BLACK, new Position("h1"));
		moves = (ArrayList<Position>) bishop.getPossibleMoves();
		assertEquals(7, moves.size());

		bishop = new Bishop(Color.BLACK, new Position("f5"));
		moves = (ArrayList<Position>) bishop.getPossibleMoves();
		assertEquals(11, moves.size());
	}
}
