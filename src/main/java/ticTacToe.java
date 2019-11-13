import java.util.Scanner;

public class ticTacToe {

    public static void main(String[] args) {

        GameBoard Board = new GameBoard();
        Board.reset();

        Scanner input = new Scanner(System.in);
        String field;
        boolean endgame = false;

        Board.print();

        do {
            System.out.println("Podaj pole " + Board.getSign() + ": ");
            field = input.nextLine();
            Board.setField(field, Board.activePlayer());
            Board.print();

            if(Board.check() == 1) {
                endgame = true;
            }

            Board.changePlayer();

        }
        while(endgame != true);
    }
}
