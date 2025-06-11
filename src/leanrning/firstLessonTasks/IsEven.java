package leanrning.firstLessonTasks;

import java.util.Scanner;

public class IsEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи натурное число и узнаем, четное оно или не четное:");
        int chislo = scanner.nextInt();
        if ((chislo % 2) == 0) {
            System.out.println("Это четное число");
        }
        else System.out.println("Это не четное число");
    }
}
