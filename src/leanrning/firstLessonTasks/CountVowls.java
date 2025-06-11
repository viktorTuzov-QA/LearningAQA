package leanrning.firstLessonTasks;

import java.util.Scanner;

public class CountVowls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку, после оценю кол-во гласных:");
        String string  = scanner.nextLine();

        String glass = "ауоиыэяюеё";
        int sum_glas;
        for (char glassone: glass.toCharArray()) {
            sum_glas = 0;
            for (char element : string.toCharArray()) {
            if (Character.toLowerCase(element) == glassone) sum_glas++;
            }

            if (sum_glas > 0) System.out.println(glassone + " в этой строке:" + sum_glas);
        }
    }

}
