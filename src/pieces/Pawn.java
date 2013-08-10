package pieces;

import java.util.List;


public class Pawn extends Piece {
	
	private Position position;
	private Color color;
	
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
		this.position = position;
		this.color = color;
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		
		if(color == Color.BLACK)
			return posControl.findPositions(Direction.blackPawnDirection());
		return posControl.findPositions(Direction.whitePawnDirection());
	}
}
