import java.util.Arrays;
import java.util.Scanner;

public class TicTackToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] field = new char[3][5];

        createField(field);
        printField(field);

        while (true) {
            System.out.print("Enter the coordinates:");

            String[] input = scanner.nextLine().split("\\s+");
            int a = 0;
            int b = 0;

            try {
                int[] integerArray = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                a = integerArray[0];
                b = integerArray[1];
                if (a > 3 || a < 0 || b > 3 || b < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (field[a - 1][b] != 'X' && field[a - 1][b] != 'O') {
                field[a - 1][b] = 'X';
                if (xWin(field)) {
                    printField(field);
                    System.out.println("X wins");
                    return;
                } else if (draw(field)) {
                    printField(field);
                    System.out.println("Draw!");
                    return;
                } else {
                    printField(field);
                }
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            while (true) {
                System.out.print("Enter the coordinates:");

                String[] input2 = scanner.nextLine().split("\\s+");
                int c = 0;
                int d = 0;

                try {
                    int[] integerArray = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();
                    c = integerArray[0];
                    d = integerArray[1];
                    if (c > 3 || c < 0 || d > 3 || d < 0) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (field[c - 1][d] != 'X' && field[c - 1][d] != 'O') {
                    field[c - 1][d] = 'O';
                    if (oWin(field)) {
                        printField(field);
                        System.out.println("O wins");
                        return;
                    } else if (draw(field)) {
                        printField(field);
                        System.out.println("Draw!");
                        return;
                    } else {
                        printField(field);
                        break;
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
        }
    }

//    private static boolean draw(char[][] field) {
//        boolean draw = false;
//        if (field[0][1] != ' ' && field[0][2] != ' ' && field[0][3] != ' '
//                && field[1][1] != ' ' && field[1][2] != ' ' && field[1][3] != ' '
//                && field[2][1] != ' ' && field[2][2] != ' ' && field[2][3] != ' ') {
//            draw = true;
//        }
//        return draw;
//    }

    private static boolean xWin(char[][] field) {
        boolean win = false;
        if ((field[0][1] == 'X' && field[0][2] == 'X' && field[0][3] == 'X')
                || (field[1][1] == 'X' && field[1][2] == 'X' && field[1][3] == 'X')
                || (field[2][1] == 'X' && field[2][2] == 'X' && field[2][3] == 'X')
                || (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X')
                || (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X')
                || (field[0][3] == 'X' && field[1][3] == 'X' && field[2][3] == 'X')
                || (field[0][1] == 'X' && field[1][2] == 'X' && field[2][3] == 'X')
                || (field[0][3] == 'X' && field[1][2] == 'X' && field[2][1] == 'X')) {
            win = true;
        }
        return win;
    }

    private static boolean oWin(char[][] field) {
        boolean win = false;
        if ((field[0][1] == 'O' && field[0][2] == 'O' && field[0][3] == 'O')
                || (field[1][1] == 'O' && field[1][2] == 'O' && field[1][3] == 'O')
                || (field[2][1] == 'O' && field[2][2] == 'O' && field[2][3] == 'O')
                || (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O')
                || (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O')
                || (field[0][3] == 'O' && field[1][3] == 'O' && field[2][3] == 'O')
                || (field[0][1] == 'O' && field[1][2] == 'O' && field[2][3] == 'O')
                || (field[0][3] == 'O' && field[1][2] == 'O' && field[2][1] == 'O')) {
            win = true;
        }
        return win;
    }

    private static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static void createField(char[][] field) {
        for (int row = 0; row < 3; row++) {
            field[row][0] = '|';
            for (int col = 1; col <= 4; col++) {
                if (col == 4) {
                    field[row][col] = '|';
                } else {
                    field[row][col] = ' ';
                }
            }
        }
    }

    private static boolean draw(char[][] field) {
        boolean draw = false;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] != ' ') {
                    draw = true;
                } else {
                    return false;

                }
            }
        }
        return draw;
    }

}
