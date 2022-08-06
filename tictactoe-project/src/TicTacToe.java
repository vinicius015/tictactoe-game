import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws InterruptedException {

        Board gameBoard = new Board();

        Scanner input = new Scanner(System.in);
        int menuOption;
        String symbolOption;
        int position;

        System.out.println("-------------------------------------");
        System.out.println("|    Bem-vindo ao Jogo da Vellha    |");
        System.out.println("|    [1] Jogar                      |");
        System.out.println("|    [Outro Caracter] Sair          |");
        System.out.println("-------------------------------------");
        menuOption = input.nextInt();

        switch (menuOption) {
            case 1:
                boolean isSymbolValid;

                do {
                    System.out.println("\nEscolha seu símbolo" +
                            "\n[X]  [O]");
                    symbolOption = input.next();

                    isSymbolValid = true;

                    if (symbolOption.charAt(0) != 'X') {
                        if (symbolOption.charAt(0) != 'O') {
                            System.out.println("Símbolo inválido, digite novamente.");
                            isSymbolValid = false;
                        }
                    }

                } while (!isSymbolValid);

                if (symbolOption.charAt(0) == 'X') {
                    gameBoard.playerSymbol = 'X';
                    gameBoard.computerSymbol = 'O';
                } else {
                    gameBoard.computerSymbol = 'X';
                    gameBoard.playerSymbol = 'O';
                }

                gameBoard.drawBoard();
                do {
                    System.out.println();

                    do {
                        System.out.println("Escolha a posição da jogada: ");
                        position = input.nextInt();

                        if (!gameBoard.placeSymbol(position, gameBoard.playerSymbol)) {
                            System.out.println("Posição já ocupada.");
                        } else {
                            gameBoard.placeSymbol(position, gameBoard.playerSymbol);
                        }
                    } while (gameBoard.isPlaceEmpty(position));

                    gameBoard.displayBoard();

                    if (!gameBoard.didSomeoneWin() && !gameBoard.isBoardFull()) {
                    System.out.println("Vez da CPU...");
                    gameBoard.computerPlay(gameBoard.computerSymbol);
                    gameBoard.displayBoard();
                    }

                } while (!gameBoard.didSomeoneWin() && !gameBoard.isBoardFull());

                if (gameBoard.didSomeoneWin()) {
                    System.out.println("GAME OVER!!");
                }

                if (gameBoard.isBoardFull()) {
                    System.out.println("GAME OVER!! DEU VELHA!!");
                }
                break;

            default:
                System.out.println("Até logo.");
                System.exit(0);
        }
    }
}
