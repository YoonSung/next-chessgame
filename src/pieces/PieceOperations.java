package pieces;

import java.util.List;

import pieces.Piece.Color;

public interface PieceOperations {
	char getSymbol();
	Color getColor();
	boolean matchColor(Color color);
	PieceOperations leave();
	PieceOperations move(Position target);
	void setPosition(Position position);
	List<Position> getPossibleMoves();
	int hashCode();
	boolean equals(Object obj);
	String toString();
}
