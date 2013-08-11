package chess;

import junit.framework.TestCase;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;
import pieces.Queen;

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

public class RankTest extends TestCase {
	static final String EMPTY_RANK = "........";
	static final String WHITE_EXCEPT_PAWN_RANK = "rnbqkbnr";
	static final String BLACK_EXCEPT_PAWN_RANK = "RNBQKBNR";
	static final String WHITE_PAWN_RANK = "pppppppp";
	static final String BLACK_PAWN_RANK = "PPPPPPPP";
	
	private Rank rank;
	
	@Override
	protected void setUp() throws Exception {
		rank = new Rank(0);
	}
	
	public void testInitializeEmpty() throws Exception {
		rank.initializeEmpty();
		assertEquals(EMPTY_RANK, rank.generate());
	}
	
	public void testInitializeWhitePawn() throws Exception {
		rank.initializeWhitePawn();
		assertEquals(WHITE_PAWN_RANK, rank.generate());
	}
	
	
	public void testInitializeBlackPawn() throws Exception {
		rank.initializeBlackPawn();
		assertEquals(BLACK_PAWN_RANK, rank.generate());
	}
	
	public void testInitializeWhiteExceptPawn() throws Exception {
		rank.initializeWhiteExceptPawn();
		assertEquals(WHITE_EXCEPT_PAWN_RANK, rank.generate());
	}
	
	public void testInitializeBlackExceptPawn() throws Exception {
		rank.initializeBlackExceptPawn();
		assertEquals(BLACK_EXCEPT_PAWN_RANK, rank.generate());
	}
	
	public void testFindPiece() throws Exception {
		rank.initializeWhiteExceptPawn();
		Position position = new Position("d1");
		assertEquals(new Queen(Color.WHITE, position), rank.findPiece(position));
		
		position = new Position("e1");
		assertEquals(new King(Color.WHITE, position), rank.findPiece(position));
	}
	
	public void testMove() throws Exception {
		rank = new Rank(1);
		rank.initializeWhitePawn();
		Position source = new Position("d2");
		Position target = new Position("d3");
		
		Piece sourcePiece = rank.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Piece targetPiece = rank.move(sourcePiece, target);
		assertEquals(new Pawn(Color.WHITE, target), targetPiece);
	}
}
