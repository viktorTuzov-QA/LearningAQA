package leanrning.firstLessonTasks;

import java.util.Scanner;

public class TimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Переведу секунды в часы минуты секунды");
        System.out.println("Введи количество секунд:");
        int seks = scanner.nextInt();

        int chas = seks / 3600;
        int mn = (seks - (chas * 3600)) / 60;
        int sek = (seks - (chas * 3600) - (mn * 60));

        String skl;

        if (chas % 100 >= 11 && chas % 100 <= 14) {
            skl =  " часов";
        } else {
            skl = switch (chas % 10) {
                case 1 -> " час ";
                case 2, 3, 4 -> " часа ";
                default -> " часов ";
            };
        }
        System.out.print("Итого: ");
        if (chas !=0) System.out.print(chas + skl);

        if (mn % 100 >= 11 && mn % 100 <= 14) {
            skl =  " минут ";
        } else {
            skl = switch (mn % 10) {
                case 1 -> " минута ";
                case 2, 3, 4 -> " минуты ";
                default -> " минут ";
            };
        }
        if (mn !=0) System.out.print(mn + skl);

        if (sek % 100 >= 11 && sek % 100 <= 14) {
            skl =  " секунд";
        } else {
            skl = switch (sek % 10) {
                case 1 -> " секунда";
                case 2, 3, 4 -> " секунды";
                default -> " секунд";
            };
        }
        if (sek !=0) System.out.print(sek + skl);



    }
}
