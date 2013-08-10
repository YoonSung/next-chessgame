package pieces;

import java.util.ArrayList;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	
	Pawn pawn;
	
	public void testGetPossibleMoves() throws Exception {
		pawn = new Pawn(Color.BLACK, new Position("d4"));
		
		ArrayList<Position> moves = new ArrayList<Position>();
		moves = (ArrayList<Position>) pawn.getPossibleMoves();
		assertEquals(1, moves.size());
		assertEquals(moves.get(0), new Position(3, 2));
		System.out.println(moves);
	}
}
