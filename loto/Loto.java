package loto;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Lottery 6 out of 36
 */
public class Loto {
    public static void main(String[] args) {
        int[] userNumbers = new int[6];
        int[] basket = new int[6];
        System.out.println("Please, input six different numbers from 1 to 36!");
        Scanner scanner = new Scanner(System.in);
        int num;
        for (int i = 0; i < 6; i++) {
            System.out.printf("Please input number #%d \n", i + 1);
            while (!((num = scanner.nextInt()) > 0 && num <= 36) || checkSameBasket36(userNumbers, num)) {
                System.out.printf("Incorrect number, please input number #%d \n", i + 1);
            }
            userNumbers[i] = num;
        }
        for (int i = 0; i < 6; i++) {
            while (checkSameBasket36(basket, num = (int)(Math.random() * 36) + 1)) {
            }
            basket[i] = num;
        }
        System.out.println("Your numbers are:");
        System.out.println(Arrays.toString(userNumbers));
        System.out.println();
        System.out.println("Lottery result is:");
        System.out.println(Arrays.toString(basket));
        int coincidences = coincidences(userNumbers, basket);
        System.out.println();
        System.out.printf("You have %d coincidences \n", coincidences);
        int prize = 0;
        switch (coincidences) {
            case 6:
                prize = 1000000;
                break;
            case 5:
                prize = 100000;
                break;
            case 4:
                prize = 10000;
                break;
            case 3:
                prize = 1000;
                break;
            case 2:
                prize = 100;
                break;
            case 1:
                prize = 10;
                break;

        }
        if (prize > 0) {
            System.out.printf("You win %d dollars", prize);
        } else {
            System.out.println("You win nothing");
        }
    }

    private static boolean checkSameBasket36(int[] numbers, int num) { // Проверка на корректность введенного значения, неповторяемость, диапазон, не 0
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return true;
            }
        }
        return false;
    }

    private static int coincidences(int[] userNumbers, int[] basket) {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (userNumbers[i] == basket[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
