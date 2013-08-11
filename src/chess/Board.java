package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Empty;
import pieces.PieceOperations;
import pieces.Position;

public class Board implements Initializable {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	public static final Board instance = new Board();
	List<Rank> ranks = new ArrayList<Rank>();
	
	private Board() {};
	public static Board getInstance(){
		return instance;
	}
	
	
	@Override
	public void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	@Override
	public void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		
		if (!target.isValid())
			return;
		
		if (findPiece(source) instanceof Empty)
			return;
		
		if (findPiece(target).matchColor(findPiece(source).getColor()))
			return;

		List<Position> possibleTogo = findPiece(source).getPossibleMoves();
		
		if(!possibleTogo.contains(target)){
			System.out.println(possibleTogo);
			return;
		}
				
				
		PieceOperations targetPiece = findPiece(source);
		PieceOperations sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
		
		targetPiece.setPosition(target);
	}
	
	void generateBoardInConsole() {
		new ConsolePrint(ranks).generateBoard();
	}
	
	void generateBoardInHtml() {
		new HtmlPrint(ranks).generateBoard();
	}
}
