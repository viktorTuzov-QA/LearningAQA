package leanrning.atm.entry;

import leanrning.atm.Exchange.ExchangeRate;
import leanrning.atm.atm.Atm;
import leanrning.atm.banknotes.DollarBanknote;
import leanrning.atm.banknotes.EuroBanknote;
import leanrning.atm.banknotes.RubBanknote;
import leanrning.atm.enums.Currency;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

import static leanrning.atm.enums.Currency.*;

public class EntryPoint {
    public static void main(String[] args) {

        System.out.println("Иницилизация банкомата");
        Atm atmstart = new Atm();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Загрузка кассет" + "\n");
        initRandom(atmstart, random, DollarBanknote.nominals, Currency.USD);
        initRandom(atmstart, random, EuroBanknote.nominals, Currency.EUR);
        initRandom(atmstart, random, RubBanknote.nominals, Currency.RUB);
        atmstart.depositTRUE = false;

        Currency val = null;
        int nominal;
        int count;
        boolean menuCHECK = true;

        while (menuCHECK) {
            System.out.println("Меню банкомата:");
            System.out.println("1: Депозит");
            System.out.println("2: Снять");
            System.out.println("3: Баланс  в  USD");
            System.out.println("4: Содержимое кассет");
            System.out.println("Любая другая: Выход");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Депозит");
                    System.out.println("Выбери валюту 1:USD, 2: EUR, 3:RUB");
                    val = switch (scanner.nextInt()) {
                        case 1 -> USD;
                        case 2 -> EUR;
                        case 3 -> RUB;
                        default -> null;
                    };
                    if (val == null) return;
                    System.out.println("Введи номинал:");
                    nominal = scanner.nextInt();
                    atmstart.deposit(1, nominal, val);
                    if (atmstart.depositTRUE) {
                        System.out.println("Депозит успешно внесен\n");
                        atmstart.depositTRUE = false;
                    }
                    break;
                case 2:
                    System.out.println("Снять");
                    System.out.println("Выбери валюту 1:USD, 2: EUR, 3:RUB");
                    val = switch (scanner.nextInt()) {
                        case 1 -> USD;
                        case 2 -> EUR;
                        case 3 -> RUB;
                        default -> null;
                    };
                    if (val == null) return;
                    System.out.println("Введи сумму:");
                    count = scanner.nextInt();
                    atmstart.withdraw(val, count);
                    break;
                case 3:

                    BigDecimal sumALL = new RubBanknote(atmstart.rubSUM).convertTo(USD);
                    sumALL = sumALL.add(new EuroBanknote(atmstart.eurSUM).convertTo(USD));
                    sumALL = sumALL.add(BigDecimal.valueOf(atmstart.usdSUM));
                    System.out.println("Баланс составляет:" + sumALL + "\n");
                    break;
                case 4:
                    System.out.println("USD:");
                    atmstart.view(USD);
                    System.out.println("EUR:");
                    atmstart.view(EUR);
                    System.out.println("RUB:");
                    atmstart.view(RUB);

                    break;

                default:
                    menuCHECK = false;
                    break;

            }
        }

    }

    private static void initRandom(Atm atmstart, Random random, int[] nominals, Currency currency) {
        for (int i = 0; i < 100; i++) {
            int randomer = random.nextInt(7);
            if (randomer != 6) {
                atmstart.deposit(1, nominals[randomer], currency);
            }
        }
    }
}