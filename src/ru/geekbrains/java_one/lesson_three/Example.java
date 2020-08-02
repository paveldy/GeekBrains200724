package ru.geekbrains.java_one.lesson_three;

import java.util.Random;
import java.util.Scanner;

public class Example {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;
    private static int quantityOfFishka;
    public static int X;
    public static int Y;
    public static boolean flag = false;
    public static int count = 0;

    private static void initField() {
        System.out.println("Введите размер поля через пробел");

//        fieldSizeX = 3;
//        fieldSizeY = 3;
        fieldSizeX = SCANNER.nextInt();
        fieldSizeY = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
        if (fieldSizeX < 5 && fieldSizeY < 5) {
            quantityOfFishka = fieldSizeX;
        } else if (fieldSizeX >= 5 && fieldSizeY >= 5) {
            quantityOfFishka = 4;
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
//        flag = false;
        int x;
        int y;
        do {
            System.out.println("Введите значение х и у через пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        int x;
        int y;
//        if (flag) {
//            if (isEmptyCell(X, Y)) {
//                field[X][Y] = DOT_AI;
//                flag = false;
//            }
//        } else if (!flag) {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));
            field[y][x] = DOT_AI;
        }
//    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        int count = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    count += 1;
                } else if (field[x][y] == DOT_EMPTY || field[x][y] != c) {
                    count = 0;
                }
//
//                if (count == quantityOfFishka - 1) {
//                    flag = true;
//                    if (isEmptyCell(x+1,y+1)) {
//                        X=x+1;
//                        Y=y+1;
//                    }
//                }else
                if (count >= quantityOfFishka) {
                    return true;
                }
            }
        }


        count = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == c) {
                    count += 1;
                } else if (field[y][x] == DOT_EMPTY || field[y][x] != c) {
                    count = 0;
                }
                if (count >= quantityOfFishka) {
                    return true;
                }

            }
        }

        count = 0;
        for (int x = 0, y = fieldSizeY - 1;x < fieldSizeX; x++, y--) {
            if (field[x][y] == c) {
                count += 1;
            } else if (field[x][y] == DOT_EMPTY || field[x][y] != c) {
                count = 0;
            }
            if (count >= quantityOfFishka) {
                return true;
            }
        }

        count = 0;
        for (int x = 0, y = 0; x < fieldSizeX; x++, y++) {
            if (field[x][y] == c) {
                count += 1;
            } else if (field[x][y] == DOT_EMPTY || field[x][y] != c) {
                count = 0;
            }
            if (count >= quantityOfFishka) {
                return true;
            }
        }
        count=0;
        return false;
    }


    public static void main(String[] args) {

        String answer;
        do {
            initField();
            printField();
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}
