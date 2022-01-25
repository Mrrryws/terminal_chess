package chess;

public class King extends Piece{
    public King(PieceColour colour){
    this.colour = colour;
    if (colour == PieceColour.WHITE)
        setSymbol("♔");
    else
        setSymbol("♚");
    }
    @Override 
    public boolean isLegitMove(int i1, int j1, int i2, int j2){
        if (i2 == i1 + 1 && j2 == j1 || j2 == j1 + 1 && i2 == i1 || i2 == i1 - 1 && j2 == j1 || j2 == j1 - 1 && i2 == i1 || i2 == i1 + 1 && j2 == j1 + 1 || i2 == i1 - 1 && j2 == j1 - 1 || i2 == i1 + 1 && j2 == j1 - 1 || i2 == i1 - 1 && j2 == j1 + 1)
            if (Board.hasPiece(i2, j2) && Board.getPiece(i2, j2).getColour() == colour)
                return false;
            else 
                return true;
        else
            return false;
    }
}
