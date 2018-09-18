/*
 * ImperialMint.java
 *
 * Copyright (c) 2018 dr wilkinson <dr-wilkinson@users.noreply.github.com>.
 *
 * This file is part of Traveller.
 *
 * Traveller is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Traveller is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Traveller.  If not, see <http ://www.gnu.org/licenses/>.
 */
package io.github.drw.rules.characters.money;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The only source of {@link Credit}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class ImperialMint {

    private static List<String> identifiers = new ArrayList<>();
    private static List<Integer> denominations = new ArrayList<>();

    static List<CreditBill> mint(int amount) {
        List<CreditBill> creditBills = new ArrayList<>();
        List<Integer> numberOfBills = getNumberOfBills(amount);
        int index = 0;
        for (int i = 0; i < numberOfBills.size(); i++) {
            int denomination = denominations.get(index);
            int total = numberOfBills.get(i);
            for (int j = 0; j < total; j++) {
                if (denomination == 1000000) {
                    creditBills.add(new CreditBill(CreditBill.Prefix.MCr, denomination));
                } else {
                    creditBills.add(new CreditBill(CreditBill.Prefix.Cr, denomination));
                }
            }
            index++;
        }
        return creditBills;
    }

    static String stamp() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String identifier = "";
        for (int i = 0; i < 14; i++) {
            identifier += uuid.charAt(i);
        }
        if (!identifiers.contains(identifier)) {
            identifiers.add(identifier);
        } else {
            stamp();
        }
        return identifier;
    }

    private static List<Integer> getNumberOfBills(int amount) {

        denominations.clear();

        List<Integer> numberOfCreditBills = new ArrayList<>();

        assert (amount <= Integer.MAX_VALUE);

        int millions = amount / 1000000;
        int remainder = amount % 1000000;
        if (millions > 0 && remainder >= 0) {
            numberOfCreditBills.add(millions);
            denominations.add(1000000);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int ten_thousands = amount / 10000;
        remainder = amount % 10000;
        if (ten_thousands > 0 && remainder >= 0) {
            numberOfCreditBills.add(ten_thousands);
            denominations.add(10000);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int thousands = amount / 1000;
        remainder = amount % 1000;
        if (thousands > 0 && remainder >= 0) {
            numberOfCreditBills.add(thousands);
            denominations.add(1000);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int five_hundreds = amount / 500;
        remainder = amount % 500;
        if (five_hundreds > 0 && remainder >= 0) {
            numberOfCreditBills.add(five_hundreds);
            denominations.add(500);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int hundreds = amount / 100;
        remainder = amount % 100;
        if (hundreds > 0 && remainder >= 0) {
            numberOfCreditBills.add(hundreds);
            denominations.add(100);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int fifties = amount / 50;
        remainder = amount % 50;
        if (fifties > 0 && remainder >= 0) {
            numberOfCreditBills.add(fifties);
            denominations.add(50);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int twenties = amount / 20;
        remainder = amount % 20;
        if (twenties > 0 && remainder >= 0) {
            numberOfCreditBills.add(twenties);
            denominations.add(20);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int tens = amount / 10;
        remainder = amount % 10;
        if (tens > 0 && remainder >= 0) {
            numberOfCreditBills.add(tens);
            denominations.add(10);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        int fives = amount / 5;
        remainder = amount % 5;
        if (fives > 0 && remainder >= 0) {
            numberOfCreditBills.add(fives);
            denominations.add(5);
        }

        assert (amount <= Integer.MAX_VALUE);

        amount = remainder;
        numberOfCreditBills.add(amount);
        denominations.add(1);

        return numberOfCreditBills;

    }
}
