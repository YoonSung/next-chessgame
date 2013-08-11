package pieces;

public enum Direction {
	//Plain one step Movement
	NORTH				( 0, 1 ),
	NORTH_EAST			( 1, 1 ),
	EAST				( 1, 0 ),
	SOUTH_EAST			( 1, -1 ),
	SOUTH				( 0, -1 ),
	SOUTH_WEST			(-1, -1 ),
	WEST				(-1, 0 ),
	NORTH_WEST			(-1, 1 ),
	
	//Paws startLine Movement
	SOUTH_SOUTH			( 0, -2 ),
	NORTH_NORTH			( 0, 2 ),
	
	//Knight Movement
	NORTH_NORTH_EAST	( 1, 2 ),
	NORTH_NORTH_WEST	(-1, 2 ),
	SOUTH_SOUTH_EAST	( 1, -2 ),
	SOUTH_SOUTH_WEST	(-1, -2 ),
	EAST_EAST_NORTH		( 2, 1 ),
	EAST_EAST_SOUTH		( 2, -1	),
	WEST_WEST_NORTH		(-2, 1 ),
	WEST_WEST_SOUTH		(-2, -1 );
	
	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}
	
	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	}

	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST };
	}

	
	public static Direction[] blackPawnStartDirection() {
		return new Direction[] {SOUTH, SOUTH_SOUTH};
	}

	public static Direction[] whitePawnStartDirection() {
		return new Direction[] {NORTH, NORTH_NORTH};
	}

	public static Direction[] whitePawnDirection() {
		return new Direction[] {NORTH};
	}

	public static Direction[] blackPawnDirection() {
		return new Direction[] {SOUTH};
	}
	
	public static Direction[] KnightDirection() {
		return new Direction[] {
								NORTH_NORTH_EAST,
								NORTH_NORTH_WEST,	
								SOUTH_SOUTH_EAST,	
								SOUTH_SOUTH_WEST,	
								EAST_EAST_NORTH	,	
								EAST_EAST_SOUTH	,	
								WEST_WEST_NORTH	,	
								WEST_WEST_SOUTH	};
	}

	public static Direction[] kingDirection() {
		return new Direction[] {
								NORTH,
								NORTH_EAST,	
								EAST,
								SOUTH_EAST,	
								SOUTH,		
								SOUTH_WEST,	
								WEST,		
								NORTH_WEST };
	}
}
