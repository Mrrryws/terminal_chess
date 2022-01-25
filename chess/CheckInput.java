package chess;
import java.util.regex.*;
public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){
        if(Pattern.matches("[1-8][a-h]", input))
            return true;
        else
		    return false;
	}
}
