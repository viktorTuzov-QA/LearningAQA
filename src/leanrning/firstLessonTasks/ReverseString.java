package leanrning.firstLessonTasks;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Это реверс строки, введи строку:");
        StringBuilder newStringB = new StringBuilder();

    String chars = scanner.nextLine();

        for (int i = chars.length() - 1; i >=0; i--) {
            newStringB.append(chars.charAt(i));
        }
        String newString = newStringB.toString();
        System.out.println(newString );
    }
}
