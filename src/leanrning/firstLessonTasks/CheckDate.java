package leanrning.firstLessonTasks;

import java.util.Scanner;

public class CheckDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Помогу чекнуть дату на корректность.");
        System.out.println("Введи даты в формате дд:мм:гггг и не забывай про разделитель \":\"");

        String [] datestring = scanner.next().split(":");

        int numberG = Integer.parseInt(datestring[2]);
        int numberM = Integer.parseInt(datestring[1]);
        int numberD = Integer.parseInt(datestring[0]);
        boolean chek = true;

        if (numberG == 0) System.out.println("год не валиден");

        else {
            switch (numberM) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (numberD > 31 || numberD < 1) {
                        System.out.println("кол-во дней не валидно");
                        chek = false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (numberD > 30 || numberD < 1) {
                        System.out.println("кол-во дней не валидно");
                        chek = false;
                    }
                    break;
                case 2:
                    if ((numberG % 400 == 0 || (numberG % 100 != 0 && numberG % 4 == 0))) {
                        if (numberD > 29 || numberD < 1) {
                            System.out.println("кол-во дней не валидно");
                            chek = false;
                        }
                    } else {
                        if (numberD > 28 || numberD < 1) {
                            System.out.println("кол-во дней не валидно");
                            chek = false;
                        }
                    }
                    break;
                default:
                    System.out.println("месяц не валиден");
                    chek = false;
                    break;
            }
            if (chek) System.out.println(" Все четко");
        }





    }
}
