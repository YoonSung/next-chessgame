package pieces;

import java.util.List;

public class Rook extends Piece {
	
	private Position position;
	
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
		this.position = position;
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position); 
		return posControl.findsLinearPositionAll();
	}
}
