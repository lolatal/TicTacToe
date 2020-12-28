package edu.tms;

import java.util.Scanner;
/* в игровом поле клетки будут иметь следующие координаты:
0, 0 | 0, 1 | 0, 2
-------------------
1, 0 | 1, 1 | 1, 2
-------------------
2, 0 | 2, 1 | 2, 2

соответсвенно координаты клеток должны вводиться не от 1 до 3, а от 0 до 2;
возможно, чтобы от 1 до 3, нужно сделать на x и y scanner.nextInt()- 1;
*/


public class TicTacToe {
    final char signX = 'X';
    final char signO = 'O';
    final char empty = '_';
    char[][] board;

    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        scanner = new Scanner(System.in);
        board = new char[3][3];

    }
    void game () {
        initialBoard();
        while (true) {
            turnPlayer1();
            printBoard();
            if (checkWin(signX)) {
                System.out.println("Игрок 1 выиграл!");
                break;
            }
            if(isBoardFull()){
                System.out.println("Ничья!");
                break;
            }
            turnaPlayer2();
            printBoard();
            if (checkWin(signO)) {
                System.out.println("Игрок 2 выиграл!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    void initialBoard () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = empty;
            }
        }
    }
    void printBoard () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    void turnPlayer1 () {
        int x, y;
        do {
            System.out.println("Игрок 1(X), введите координаты клетки по горизонтали и вертикали:");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!cellNotValid(x, y));
        board[x][y] = signX;
    }

    void turnaPlayer2 () {
        int x, y;
        do {
            System.out.println("Игрок 2 (O), введите координаты клетки по горизонтали и вертикали:");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!cellNotValid(x, y));
        board[x][y] = signO;
    }
    boolean cellNotValid(int x, int y){
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return board[x][y] == empty;
    }
    boolean checkWin ( char dot){
        for (int a = 0; a < 3; a++)
            if ((board[a][0] == dot && board[a][1] == dot && board[a][2] == dot) ||
                    (board[0][a] == dot && board[1][a] == dot && board[2][a] == dot))
                return true;
        if ((board[0][0] == dot && board[1][1] == dot && board[2][2] == dot) ||
                (board[2][0] == dot && board[1][1] == dot && board[0][2] == dot))
            return true;
        return false;
    }
    boolean isBoardFull () {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == empty)
                    return false;
        return true;
    }
}
