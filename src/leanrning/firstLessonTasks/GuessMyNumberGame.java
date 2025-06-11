package leanrning.firstLessonTasks;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Угадай число от 1 до 100");

        int random = new Random().nextInt(100) + 1;
        int i = 1;
        int popitka;

        while (random != (popitka = scanner.nextInt())) {
            if (popitka > random) {System.out.println("Загаданное число меньше"); }
            else System.out.println("Загаданное число больше");
            i++;
        }
        System.out.println("УРА, ты угадал за " + i + " попыток");

    }
}
