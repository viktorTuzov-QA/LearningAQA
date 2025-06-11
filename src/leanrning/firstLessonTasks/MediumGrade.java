package leanrning.firstLessonTasks;

import java.util.Scanner;


public class MediumGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Это расчет среднего арифметического");
        System.out.println("Введи оценки от 1 до 5 баллао, подряд, разделяя запятой");
        String [] arr = scanner.next().split(",");

        String [] balls = {"1","2","3","4","5"};
        int sum = 0;
        boolean chek = false;

        for (String element: arr) {
            chek = false;
            for (String ball : balls) {
                if (element.equals(ball)) {
                    chek = true;
                    break;
                }
            }
            if (chek) {
                sum = sum + Integer.parseInt(element);
            } else break;

        }
        if (chek) {
            double itog = (double) sum / arr.length;
            itog = ((double) Math.round(itog * 100) / 100);
            System.out.println(itog);
        } else System.out.println("Ошибка при вводе");

    }
}
