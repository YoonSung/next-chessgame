package pieces;

import java.util.List;

public class King extends Piece {
	
	private Position position;
	
	public King(Color color, Position position) {
		super(color, Type.KING, position);
		this.position = position;
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		return posControl.findPosition(Direction.kingDirection());
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}
}

