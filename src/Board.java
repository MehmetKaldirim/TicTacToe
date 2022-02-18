import java.util.Scanner;

class Board {


    static int[] coordArray = new int[2];
    static String coordinat = "";

    static char[][] board = new char[3][3];



    void print() {

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.print("| ");
                } else if (j == 4) {
                    System.out.print("|");
                } else {
                    System.out.print(board[i][j - 1] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    void creatBoard() {


        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                board[i][j] = ' ';
            }
        }

    }

    String checkWinner() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 264) {
                result = "X wins";
            }

            if (board[i][0] + board[i][1] + board[i][2] == 237) {
                result = "O wins";
            }

            if (board[0][i] + board[1][i] + board[2][i] == 264) {
                result = "X wins";
            }

            if (board[0][i] + board[1][i] + board[2][i] == 237) {
                result = "O wins";
            }
        }

        if (board[0][0] + board[1][1] + board[2][2] == 264) {
            result = "X wins";
        }

        if (board[0][0] + board[1][1] + board[2][2] == 237) {
            result = "O wins";
        }

        if (board[0][2] + board[1][1] + board[2][0] == 264) {
            result = "X wins";
        }

        if (board[0][2] + board[1][1] + board[2][0] == 237) {
            result = "O wins";
        }

        if( !(result.equals("X wins") || ( result.equals("O wins")))){
            result = "continue";
        }
        return result;
    }

    private static char [][] emptyArray() {
        char[][] emptyBoard =new char[2][2];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                emptyBoard[i][j] = ' ';
            }
        }
        return emptyBoard;
    }

    private static String getStringInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

    public void markInput(char user) {
        char a = user;
        getUserInput();
        int num1 = coordArray[0];
        int num2 = coordArray[1];
        if ((board[num1 - 1][num2 - 1] == 'X' || board[num1 - 1][num2 - 1] == 'O')) {
            System.out.println("This cell is occupied! Choose another one!");
            markInput(user);

        } else if (board[num1 - 1][num2 - 1] == ' ') {
            System.out.println("a = " + a);
            board[num1 - 1][num2 - 1] = user;
        }
    }

    private static void getUserInput() {
        System.out.print("Enter the coordinates:");
        coordinat = getStringInput();
        coordinat = coordinat.replaceAll(" ", "");
        if (coordinat.length() < 2) {
            System.out.println("You should enter two numbers!");
            getUserInput();
            coordinat = coordinat.replaceAll(" ", "");
        } else if (coordinat.charAt(0) < '0' || coordinat.charAt(0) > '9' ||
                coordinat.charAt(1) < '0' || coordinat.charAt(1) > '9') {

            System.out.println("You should enter numbers!");
            getUserInput();
        } else if (coordinat.charAt(0) - 48 > 3 || coordinat.charAt(0) - 48 < 1 ||
                coordinat.charAt(1) - 48 > 3 || coordinat.charAt(1) - 48 < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            getUserInput();
        }
        coordArray[0] = coordinat.charAt(0) - 48;
        coordArray[1] = coordinat.charAt(1) - 48;
    }
}