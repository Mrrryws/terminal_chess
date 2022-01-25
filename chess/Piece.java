package chess;

//This class requires your input
public abstract class Piece {
    PieceColour colour;
	private String symbol;
    public void setSymbol(String newSymbol) {
        symbol = newSymbol;
    }
    public PieceColour getColour() {
        return colour;
    }
    public abstract boolean isLegitMove(int i1, int j1, int i2, int j2);
	public String getSymbol() {
		return symbol;
	}	
}
