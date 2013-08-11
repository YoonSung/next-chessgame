package pieces;

import java.util.ArrayList;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	
	Pawn pawn;
	
	public void testGetPossibleMoves() throws Exception {
		
		ArrayList<Position> moves = new ArrayList<Position>();
		
		
		//test plain blackPawn position
		pawn = new Pawn(Color.BLACK, new Position("d4"));
		moves = (ArrayList<Position>) pawn.getPossibleMoves();
		assertEquals(1, moves.size());
		assertEquals(moves.get(0), new Position(3, 2));
		System.out.println(moves);
		
		//test startLine blackPawn position
		ArrayList<Position> possibleTomove = new ArrayList<Position>();
		possibleTomove.add(new Position("a6"));
		possibleTomove.add(new Position("a5"));
		pawn = new Pawn(Color.BLACK, new Position("a7"));
		moves = (ArrayList<Position>) pawn.getPossibleMoves();
		assertEquals(2, moves.size());
		assertEquals(possibleTomove, moves);
		System.out.println(moves);
		
		
		//test plain whitePawn position
		pawn = new Pawn(Color.WHITE, new Position("d3"));
		moves = (ArrayList<Position>) pawn.getPossibleMoves();
		assertEquals(1, moves.size());
		assertEquals(moves.get(0), new Position("d4"));
		System.out.println(moves);
		
		//test startline blackPawn position
		ArrayList<Position> possibleTomove2 = new ArrayList<Position>();
		possibleTomove2.add(new Position("d3"));
		possibleTomove2.add(new Position("d4"));
		pawn = new Pawn(Color.WHITE, new Position("d2"));
		moves = (ArrayList<Position>) pawn.getPossibleMoves();
		assertEquals(2, moves.size());
		assertEquals(possibleTomove2, moves);
		System.out.println(moves);
	}
}
