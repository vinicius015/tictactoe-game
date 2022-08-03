import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws InterruptedException {

        Board newGame = new Board();
        Scanner input = new Scanner(System.in);
        int menuOption;
        String symbolOption;
        int position;

        System.out.println("-------------------------------------");
        System.out.println("|    Bem-vindo ao Jogo da Vellha    |");
        System.out.println("|    [1] Jogar [2] Sair             |");
        System.out.println("-------------------------------------");
        menuOption = input.nextInt();

        do {
            if (menuOption == 1) {
                System.out.println("\nEscolha seu símbolo" +
                        "\n[X]  [O]");
                symbolOption = input.next();

                System.out.println();
                newGame.drawBoard();
                System.out.println("Escolha a posição da jogada: ");
                position = input.nextInt();

                newGame.placeSymbol(position, symbolOption.charAt(0), newGame.board);
                newGame.displayBoard();

                System.out.println("Vez da CPU...");
                newGame.computerPlay(newGame.board, 'O');
                newGame.displayBoard();
            }
        } while (!newGame.didSomeoneWin(newGame.board) || !newGame.isBoardFull(newGame.board));

    }
}
