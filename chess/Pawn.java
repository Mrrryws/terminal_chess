package chess;

import java.lang.Math;

public class Pawn extends Piece {
    public Pawn(PieceColour colour) {
        this.colour = colour;
        if (colour == PieceColour.WHITE)
            setSymbol("♙");
        else
            setSymbol("♟︎");
    }

    @Override
    public boolean isLegitMove(int i1, int j1, int i2, int j2) {
        if (j1 == j2 && i1 == i2)
            return false;
        if (colour == PieceColour.WHITE) {
            if (i2 - i1 == -1 && j2 - j1 == 0 && !Board.hasPiece(i2, j2))
                return true;
            if (i2 - i1 == -2 && j2 - j1 == 0 && !Board.hasPiece(i2, j2) && !Board.hasPiece(i2 + 1, j2) && i1 == 6)
                return true;
            if (i2 - i1 == -1 && Math.abs(j2 - j1) == 1 && Board.hasPiece(i2, j2) && Board.getPiece(i2, j2).getColour() != colour)
                return true;

        }
        if (colour == PieceColour.BLACK) {
            if (i2 - i1 == 1 && j2 - j1 == 0 && !Board.hasPiece(i2, j2))
                return true;
            if (i2 - i1 == 2 && j2 - j1 == 0 && !Board.hasPiece(i2, j2) && !Board.hasPiece(i2 - 1, j2) && i1 == 1)
                return true;
            if (i2 - i1 == 1 && Math.abs(j2 - j1) == 1 && Board.hasPiece(i2, j2) && Board.getPiece(i2, j2).getColour() != colour)
                return true;

        }
        return false;
    }
}




