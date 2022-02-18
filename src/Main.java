public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.creatBoard();
        board.print();
        int counter = 0;

        while (true) {
            counter ++;
            board.markInput('X');
            board.print();
            String result = board.checkWinner();
            if (!result.equals("continue")) {
                System.out.println(result);
                return;
            }

            if (counter == 9) {
                System.out.println("Draw");
                return;
            }
            board.markInput('O');
            board.print();
            counter++;
            result = board.checkWinner();
            if (!result.equals("continue")) {
                System.out.println(result);
                return;

            }
        }

    }

}
