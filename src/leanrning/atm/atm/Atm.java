package leanrning.atm.atm;

import leanrning.atm.banknotes.DollarBanknote;
import leanrning.atm.banknotes.EuroBanknote;
import leanrning.atm.banknotes.RubBanknote;
import leanrning.atm.enums.Currency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static leanrning.atm.enums.Currency.*;

public class Atm {
    private static final int MAX_SIZE = 100;

    private List<Integer> usdCS = new ArrayList<>();
    private List<Integer>  eurCS = new ArrayList<>();
    private List<Integer>  rubCS = new ArrayList<>();
    public int usdSUM = 0;
    public int eurSUM = 0;
    public int rubSUM = 0;
    public boolean depositTRUE = false;




    public void deposit(int count, int nominal, Currency currency) {
        switch (currency) {
            case USD:
                if (!DollarBanknote.CheckNominal(nominal)) {
                    return; }

                if (usdCS.size() + count > MAX_SIZE) {
                        System.out.println("Нет места в каасете для данного колличества купюр");

                    return; }

                for (int i = 0; i < count; i++) {
                    usdCS.add(nominal);
                    usdSUM = usdSUM + nominal;
                }
                depositTRUE = true;
                break;

            case EUR:
                if (!EuroBanknote.CheckNominal(nominal)) {
                    return; }

                if (eurCS.size() + count > MAX_SIZE) {
                    System.out.println("Нет места в каасете для данного колличества купюр");

                    return; }

                for (int i = 0; i < count; i++) {
                    eurCS.add(nominal);
                    eurSUM = eurSUM + nominal;
                }
                depositTRUE = true;
                break;

            case RUB:
                if (!RubBanknote.CheckNominal(nominal)) {
                    return; }

                if (rubCS.size() + count > MAX_SIZE) {
                    System.out.println("Нет места в каасете для данного колличества купюр");

                    return; }

                for (int i = 0; i < count; i++) {
                    rubCS.add(nominal);
                    rubSUM = rubSUM + nominal;
                }
                depositTRUE = true;
                break;

        }

    }

    public void view(Currency currency) {
        switch (currency) {
            case USD:
                System.out.println(usdCS);
                System.out.println("Кол-во: " + usdCS.size() + "\n");
                break;

            case EUR:
                System.out.println(eurCS);
                System.out.println("Кол-во: " + eurCS.size() + "\n");
                break;

            case RUB:
                System.out.println(rubCS);
                System.out.println("Кол-во: " + rubCS.size() + "\n");
                break;
        }

    }

    public void withdraw(Currency currency,int count ) {

        int[] nominals;
        List<Integer> cashStorage;
        int sumTEMP;



        switch (currency) {
            case USD:
                nominals = DollarBanknote.nominals;
                cashStorage = new ArrayList<>(usdCS);
                sumTEMP = usdSUM;
                break;

            case EUR:
                nominals = EuroBanknote.nominals;
                cashStorage = new ArrayList<>(eurCS);
                sumTEMP = eurSUM;
                break;

            case RUB:
                nominals = RubBanknote.nominals;
                cashStorage = new ArrayList<>(rubCS);
                sumTEMP = rubSUM;
                break;

            default:
               return;
        }

        if ((count % nominals[0]) != 0 || (count > sumTEMP)) {
            System.out.println("Невозможно выдать запрашиваемую сумму, выберите другую сумму" + "\n");
            return;
        }

            List<Integer> index = new ArrayList<>();
            int tempCount = count;

            for (int i = nominals.length - 1; i >= 0; i--) {
                int nom = nominals[i];
                if (((tempCount / nom) == 0) && ((tempCount % nom) != 0)) {
                    continue;
                }
                for (int j = 0; j < cashStorage.size(); j++) {
                    int temp = cashStorage.get(j);

                    if ((temp == nom) && ((tempCount / nom) > 1)) {
                        index.add(j);
                        tempCount = tempCount - nom;
                        continue;
                    }
                    if ((temp == nom) && (((tempCount / nom) == 1) || (tempCount / nom) == 0)) {
                        index.add(j);
                        tempCount = tempCount - nom;
                        break;
                    }
                }
                if (tempCount == 0) {
                    index.sort(Collections.reverseOrder());
                    for (int k : index) {
                        cashStorage.remove(k);
                    }
                    switch (currency) {
                        case USD:
                            usdCS = cashStorage;
                            usdSUM = usdSUM - count;
                            break;
                        case EUR:
                            eurCS = cashStorage;
                            eurSUM = eurSUM - count;
                            break;
                        case RUB:
                            rubCS = cashStorage;
                            rubSUM = rubSUM -count;
                            break;
                        default:
                            break;
                    }
                    System.out.println("Купюры успешно выданы");
                    break;
                }
            }
            if (tempCount != 0) {
                System.out.println("Невозможно выдать запрашиваемую сумму");
            }





    }

    public int setSUM(Currency currency) {
        int setSUM;
        switch (currency) {

            case USD -> setSUM = usdSUM;
            case EUR -> setSUM = eurSUM;
            case RUB -> setSUM = rubSUM;

            default -> setSUM = 0;
        };


        return setSUM;
    }
}
