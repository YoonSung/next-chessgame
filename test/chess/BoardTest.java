package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece.Color;
import pieces.PieceOperations;
import pieces.Position;
import pieces.Rook;

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

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		board.generateBoardInConsole();
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		board.generateBoardInConsole();
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		board.generateBoardInConsole();
	}
	
	public void testMoveEmptyPiece() throws Exception {
		board.initialize();
		Position a3 = new Position("a3");
		Position a2 = new Position("a2");
		
		Empty empty = new Empty(Color.NOCOLOR, a3);
		
		board.movePiece(a3, a2);
		assertEquals(empty, board.findPiece("a3"));
		assertEquals(new Pawn(Color.WHITE, a2), board.findPiece("a2"));
		board.generateBoardInConsole();
	}
	
	public void testMoveInvalidPosition() throws Exception {
		board.initialize();
		Position invalidPosition = new Position(-1, 1);
		Position a2 = new Position("a2");
		
		board.movePiece(a2, invalidPosition);
		assertEquals(new Pawn(Color.WHITE, a2), board.findPiece("a2"));
		board.generateBoardInConsole();		
	}
	
	public void testMoveFriendsForcePosition() throws Exception {
		board.initialize();
		Position freindPosition = new Position(0, 1);
		Position a1 = new Position("a1");
		
		board.movePiece(a1, freindPosition);
		assertEquals(new Rook(Color.WHITE, a1), board.findPiece("a1"));
		board.generateBoardInConsole();
	}
	
	public void testMoveImpossibleMovesPosition() throws Exception {
		
		//		  ChessBoard
		//
		//	a8 b8 c8 d8 e8 f8 g8 h8
		//	a7 b7 c7 d7 e7 f7 g7 h7
		//	a6 b6 c6 d6 e6 f6 g6 h6
		//	a5 b5 c5 d5 e5 f5 g5 h5
		//	a4 b4 c4 d4 e4 f4 g4 h4
		//	a3 b3 c3 d3 e3 f3 g3 h3
		//	a2 b2 c2 d2 e2 f2 g2 h2
		//	a1 b1 c1 d1 e1 f1 g1 h1
		
		board.initialize();
		
		Position e5 = new Position("e5");
		Position e6 = new Position("e6");
		Position d5 = new Position("d5");
		Position d6 = new Position("d6");
		
		board.movePiece("a2", "a4");
		board.movePiece("a1", "a3");
		board.movePiece("a3", "e3");
		board.movePiece("e3", "e5");
		board.generateBoardInConsole();
		
		board.movePiece(e5, e6);
		assertEquals(new Rook(Color.WHITE, e6), board.findPiece(e6));
		
		board.movePiece(e6, d6);
		assertEquals(new Rook(Color.WHITE, d6), board.findPiece(d6));
		
		board.movePiece(d6, d5);
		assertEquals(new Rook(Color.WHITE, d5), board.findPiece(d5));
		
		Position impossibleTogo = new Position("c4");
		board.movePiece(d5, impossibleTogo);
		assertEquals(new Empty(Color.NOCOLOR, impossibleTogo), board.findPiece(impossibleTogo));
		
		assertEquals(new Rook(Color.WHITE, d5), board.findPiece(d5));
	}
}
