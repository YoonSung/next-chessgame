package pieces;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import pieces.Piece.Color;

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

public class KnightTest extends TestCase {
	
	Knight knight;

	public void testGetPossibleMoves() throws Exception {
		
		ArrayList<Position> possibleTogo = new ArrayList<Position>();
		List<Position> moves;
		
		possibleTogo.add(new Position("g3"));
		possibleTogo.add(new Position("f2"));

		knight = new Knight(Color.BLACK, new Position("h1"));
		moves = knight.getPossibleMoves();
		assertEquals(2, moves.size());
		assertEquals(moves, possibleTogo);
		System.out.println(moves);
		
		knight = new Knight(Color.BLACK, new Position("e4"));
		moves = knight.getPossibleMoves();
		assertEquals(8, moves.size());
		System.out.println(moves);
	}
}
