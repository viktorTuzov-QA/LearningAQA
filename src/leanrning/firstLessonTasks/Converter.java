package leanrning.firstLessonTasks;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.Scanner;



public class Converter {
    public static void main(String[] args) {

        System.out.println("Это конвертер курса Рубля в Доллары.");

        Scanner scanner = new Scanner(System.in);
        BigDecimal kurs = new BigDecimal("81.49");

        System.out.println("Текущий курс: 1 USD = " + kurs + " RUB");
        System.out.println("Введи количество RUB");

        BigDecimal rubl = new BigDecimal(scanner.next());
        BigDecimal itog = rubl.divide(kurs, 2, RoundingMode.CEILING);

        System.out.println ("Это " + itog + " USD");

    }
}
