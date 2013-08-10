package pieces;

import java.util.ArrayList;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class EmptyTest extends TestCase {
	
	Empty empty;
	
	@Override
	public void setName(String name) {
		super.setName(name);
		empty = new Empty(Color.NOCOLOR, new Position("a3"));
	}
	
	public void testGetPossibleMoves() throws Exception {
		ArrayList<Position> moves = (ArrayList<Position>) empty.getPossibleMoves();
		assertEquals(0, moves.size());
	}
}
