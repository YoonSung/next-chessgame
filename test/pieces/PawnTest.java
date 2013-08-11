package pieces;

import java.util.ArrayList;

import pieces.Piece.Color;
import junit.framework.TestCase;

//		  ChessBoard
//
//	a8 b8 c8 d8 e8 f8 g8 h8
//	a7 b7 c7 d7 e7 f7 g7 h7
//  a6 b6 c6 d6 e6 f6 g6 h6
//  a5 b5 c5 d5 e5 f5 g5 h5
//  a4 b4 c4 d4 e4 f4 g4 h4
//  a3 b3 c3 d3 e3 f3 g3 h3
//  a2 b2 c2 d2 e2 f2 g2 h2
//  a1 b1 c1 d1 e1 f1 g1 h1

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
