public class GameBoard {

    private int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private final String[] PLAYER_SIGN = {" ", "X", "O"};
    private int activePlayer = 1;

    public void changePlayer() {
        if (activePlayer == 1) {
            activePlayer = 2;
        } else {
            activePlayer = 1;
        }
    }

    public int activePlayer() {
        return activePlayer;
    }

    public String getSign() {
        return PLAYER_SIGN[activePlayer];
    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int check() {

        int[][] magicSquare = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int result = 0;

        for (int i = 0; i < board.length; i++) {

            int row = board[i][0] * magicSquare[i][0] + board[i][1] * magicSquare[i][1] + board[i][2] * magicSquare[i][2];
            int col = board[0][i] * magicSquare[0][i] + board[i][1] * magicSquare[i][1] + board[2][2] * magicSquare[i][2];

            if(row == 15 || col == 15) {
                result = 1;
            } else if (row == 30 || col == 30) {
                result = 2;
            }
        }



        int diagR = board[2][0]*magicSquare[2][0] + board[1][1]*magicSquare[1][1] + board[0][2]*magicSquare[0][2];
        int diagL = board[0][0]*magicSquare[0][0] + board[1][1]*magicSquare[1][1] + board[2][2]*magicSquare[2][2];

        if (diagR == 15 || diagL == 15) {
            result = 1;
        } else if (diagR == 30 || diagL == 30) {
            result = 2;
        }

        return result;
    }

    public void setField(String field, int player) {
        String ccoordY = String.valueOf(field.toUpperCase().charAt(0));
        int coordX = Integer.parseInt(String.valueOf(field.charAt(1))) - 1;
        int coordY = 0;

        if (ccoordY.equals("A")) {
            coordY = 0;
        } else if (ccoordY.equals("B")) {
            coordY = 1;
        } else if (ccoordY.equals("C")) {
            coordY = 2;
        }
        board[coordY][coordX] = player;
    }

    public void print() {
        System.out.println("    1   2   3");
        String[] vert = {"A.", "B.", "C."};
        for (int i = 0; i < board.length; i++) {
            System.out.print(vert[i]);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" [" + PLAYER_SIGN[board[i][j]] + "]");
            }
            System.out.println("");
        }
    }

}
