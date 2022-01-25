package chess;

public class Queen extends Piece{
    public Queen(PieceColour colour){
        this.colour = colour;
        if (colour == PieceColour.WHITE)
            setSymbol("♕");
        else
            setSymbol("♛");
    }
    @Override
    public boolean isLegitMove(int i1, int j1, int i2, int j2) {
        if(i1 - i2 == j1 - j2 || i1 - i2 == j2 - j1 || j1 == j2 || i1 == i2 ) {
            if (j1 == j2 && i1 == i2)
                return false;
            else if ( i2 == i1 ) {
                int dir = (j1 < j2) ? 1 : -1;
                for (j1 = j1 + dir; j1 != j2; j1 += dir)
                    if (Board.hasPiece(i1,j1))
                        return false;
            }
            else if ( j2 == j1 ) {
                int dir = (i1 < i2) ? 1 : -1;
                for (i1 = i1 + dir; i1 != i2; i1 += dir)
                    if (Board.hasPiece(i1, j1))
                        return false;
            }
            else {
                int diri = (i1 < i2) ? 1 : -1;
                int dirj = (j1 < j2) ? 1 : -1;
                for (i1 = i1 + diri, j1 = j1 + dirj; i1 != i2 && j1 != j2; i1 += diri, j1 += dirj)
                    if (Board.hasPiece(i1,j1))
                        return false;
            }
            if (Board.hasPiece(i2, j2) && Board.getPiece(i2, j2).getColour() == colour)
                return false;
            else
                return true;
        }
        else
            return false;
    }
}

