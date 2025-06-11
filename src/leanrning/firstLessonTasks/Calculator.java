package leanrning.firstLessonTasks;

import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        String attention = "ошибка в веденных значениях, будь внимателен:";
        String inputI = " Сначала введи 1ое значение,  ВВОД. потом 2ое, ВВОД. Для не целых чисел используй запятую";

        System.out.println("Это калькулятор для двух числе. Для начала выбери действие:");
        System.out.println("1 - сложение");
        System.out.println("2 - вычитание");
        System.out.println("3 - умножение");
        System.out.println("4 - деление");
        System.out.println("любое - выход");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Твой выбор сложение." + inputI);
                    try {
                        System.out.println("= " + scanner.nextBigDecimal().add(scanner.nextBigDecimal()));
                    } catch (Exception e) {
                        System.out.println(attention + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Твой выбор вычитание." + inputI);
                    try {
                        System.out.println("= " + scanner.nextBigDecimal().subtract(scanner.nextBigDecimal()));
                    } catch (Exception e) {
                        System.out.println(attention + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Твой выбор умножение." + inputI);
                    try {
                        System.out.println("= " + scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()));
                    } catch (Exception e) {
                        System.out.println(attention + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Твой выбор деление." + inputI);
                    try {
                        System.out.println("= " + scanner.nextBigDecimal().divide(scanner.nextBigDecimal(),10, RoundingMode.CEILING).stripTrailingZeros());
                    } catch (Exception e) {
                        System.out.println(attention + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Вышли");
                    break;

            }

    }
}