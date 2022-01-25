package chess;

//This class requires your input
public class Square {
    private Piece p; // is null
	private boolean hasPiece; //is false
    
    public Piece getPiece() {
        return p;
}	
    public void setPiece(Piece pIn){
        p = pIn;
        if (pIn == null){
        hasPiece = false;
    }
        else {
        hasPiece = true;
    }
}
    public void removePiece(){
        p = null;
        hasPiece = false;  
}
	public boolean hasPiece(){
		return hasPiece;
	}	
}
