package pieces;

import java.util.List;


public class Pawn extends Piece {
	
	private Position position;
	
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
		this.position = position;
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		if(this.isBlack())
			return posControl.findBlackPawnPositions();
		return posControl.findWhtePawnPositions();
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}
}
