package pieces;

import java.util.ArrayList;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class RookTest extends TestCase {
	
	Rook rook;
	
	@Override
	public void setName(String name) {
		super.setName(name);
		rook = new Rook(Color.BLACK, new Position("a8"));
	}
	
	public void testGetPossibleMoves() throws Exception {
		ArrayList<Position> moves = new ArrayList<Position>();
		moves = (ArrayList<Position>) rook.getPossibleMoves(); 
		
		assertEquals(14, moves.size());
		System.out.println(moves);
		
	}
}
