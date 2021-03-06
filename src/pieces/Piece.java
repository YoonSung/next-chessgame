package pieces;

public abstract class Piece implements PieceOperations{
	public enum Color {
		WHITE,
		BLACK,
		NOCOLOR;
	}
	
	public enum Type {
		PAWN('p'),
		ROOK('r'),
		KNIGHT('n'),
		BISHOP('b'),
		QUEEN('q'),
		KING('k'),
		EMPTY('.');
		
		private char symbol;
		
		private Type(char symbol) {
			this.symbol = symbol;
		}
		
		public char getSymbol() {
			return symbol;
		}
	}
	
	private Color color;
	private Type type;
	private Position position;
	
	Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
	}
	
	@Override
	public char getSymbol() {
		return this.color == Color.BLACK ? Character.toUpperCase(type.getSymbol()) : type.getSymbol();  
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	
    protected boolean isWhite() {
    	return this.color == Color.WHITE ? true : false;
    }

    protected boolean isBlack() {
    	return this.color == Color.BLACK ? true : false;
    }
    
    @Override
	public boolean matchColor(Color color) {
		return this.color == color ? true : false;
	}

    @Override
	public Piece leave() {
		return new Empty(Color.NOCOLOR, this.position);
	}
	
    @Override
	public Piece move(Position target) {
		this.position = target;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + ", position="
				+ position + "]";
	}
}
