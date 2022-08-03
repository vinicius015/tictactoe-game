import java.util.Random;

public class Board {

    char[][] board = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    char playerSymbol;
    char computerSymbol;


    public void drawBoard() {
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| 7 | 8 | 9 |");
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            if (i == 0) {
                System.out.println("| " + board[i][i] + " | " + board[i][i + 1] + " | " + board[i][i + 2] + " |");
            } else if (i == 1) {
                System.out.println("| " + board[i][i - 1] + " | " + board[i][i] + " | " + board[i][i + 1] + " |");
            } else {
                System.out.println("| " + board[i][i - 2] + " | " + board[i][i - 1] + " | " + board[i][i] + " |");
            }
        }
    }

    public boolean isPlaceEmpty(char[][] board, int position) {
        int row = calcRow(position);
        int column = calcColumn(position);

        return board[row][column] == ' ';
    }

    public void placeSymbol(int position, char symbolType, char[][] board) {
        int row = calcRow(position);
        int column = calcColumn(position);

        board[row][column] = symbolType;
    }

    public void computerPlay(char[][] board, char computerSymbol) {
        Random generateNumber = new Random();
        int position = 0;
        do {
            position = generateNumber.nextInt(8)+1;
            int row = calcRow(position);
            int column = calcColumn(position);

            if (isPlaceEmpty(board, position)) {
            board[row][column] = computerSymbol;
            }

        } while (isPlaceEmpty(board, position));
    }

    public int calcRow(int position) {
        return (position - 1) / 3;
    }

    public int calcColumn(int position) {
        return (position - (calcRow(position) * 3)) - 1;
    }

    public boolean didSomeoneWin(char[][] board) {

        char symbol = 'X';
        boolean isWon = false;

        for (int i = 0; i < 2; i++) {
            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol & board[1][0] == symbol & board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                isWon = true;
            }
                symbol = 'O';
        }
        return isWon;
    }

    public boolean isBoardFull(char[][] board) {

        int nums = 0;
        for (int i =0; i<3; i++) {
            for (int j =0; j < 3; j++) {
                if (board[i][j] != ' ') {
                    nums += 1;
                }
            }
        }
        return nums == 9;
    }

    ;

}
