package chess;

public class Game {
    private static boolean gameEnd=false;
    static int turnNumber = 1;
    //This method requires your input
    public static void play(){
        CheckInput chkInpt = new CheckInput();
        while (!gameEnd){
            if(turnNumber % 2 == 1)
                System.out.println("----- Whites move -----");
            else
                System.out.println("----- Blacks move -----");
            while (true) {
                System.out.println("Enter origin: ");
                String userInputOrigin = System.console().readLine();
                while (!chkInpt.checkCoordinateValidity(userInputOrigin) && !userInputOrigin.equals("END")) {
                    System.out.println("Input was not correct! Please try again!");
                    System.out.println("Enter origin: ");
                    userInputOrigin = System.console().readLine();

                }
                if (userInputOrigin.equals("END")) {
                    System.out.println("You decided to end the game! :( See you next time!");
                    return;
                }
                int i1 = userInputOrigin.charAt(0) - '1';
                int j1 = userInputOrigin.charAt(1) - 'a';

                System.out.println("Enter destination: ");
                String userInputDestination = System.console().readLine();
                while (!chkInpt.checkCoordinateValidity(userInputDestination) && !userInputDestination.equals("end")) {
                    System.out.println("Input was not correct! Please try again!");
                    System.out.println("Enter destination: ");
                    userInputDestination = System.console().readLine();
                }
                if (userInputDestination.equals("end")) {
                    System.out.println("You decided to end the game! :( See you next time!");
                    return;
                }
                int i2 = userInputDestination.charAt(0) - '1';
                int j2 = userInputDestination.charAt(1) - 'a';

                if (Board.hasPiece(i1, j1)) {
                    Piece selPiece = Board.getPiece(i1, j1);
                    if ((selPiece.getColour() == PieceColour.WHITE && turnNumber % 2 == 1) || (selPiece.getColour() == PieceColour.BLACK && turnNumber % 2 != 1))
                        if (selPiece.isLegitMove(i1, j1, i2, j2)) {
                            gameEnd = Board.movePiece(i1, j1, i2, j2, selPiece);
                            break;
                        }
                        else {
                            System.out.println("Invalid move. Please enter again!");
                            continue;
                        }
                    else {
                        System.out.println("You tried to move the opponent's pieces! Please move your own! :)");
                        continue;
                    }
                }
                else {
                    System.out.println("There is no piece to move in the selected square! Please try again!");
                    continue;
                }
            }
            Board.printBoard();
            turnNumber++;
        }
        turnNumber--;
        if(turnNumber % 2 == 1)
            System.out.println("----- Whites Win -----");
        else
            System.out.println("----- Blacks Win -----");
    }

    //This method should not be edited
    public static void main (String args[]){
        Board.initialiseBoard();
        Board.initialisePieces();
        Board.printBoard();
        Game.play();
    }
}
