package pieces;

import java.util.ArrayList;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class KingTest extends TestCase {
	
	King king;
	
	public void testGetPossibleMoves() throws Exception {
		ArrayList<Position> moves = new ArrayList<Position>();
		
		king = new King(Color.BLACK, new Position("f5"));
		moves = (ArrayList<Position>) king.getPossibleMoves();
		assertEquals(8, moves.size());
		System.out.println(moves);
	}
}
