/*
 * Credits.java
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
import java.util.Collections;
import java.util.List;

/**
 * Encapsulates a store of {@link Credit}s.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Credits {

    private List<CreditBill> creditBills = new ArrayList<>();

    public Credits() {
    }

    private Credits(List<CreditBill> creditBills) {
        this.creditBills = creditBills;
    }

    public void deposit(int amount) {
        creditBills.addAll(ImperialMint.mint(amount));
    }

    public void withdraw(int amount) {
        if (amount <= getTotal()) {

        }
    }

    public int getTotal() {
        int total = 0;
        for (CreditBill creditBill : creditBills) {
            total += creditBill.getValue();
        }
        return total;
    }

    List<CreditBill> getUnmodifiable() {
        return Collections.unmodifiableList(creditBills);
    }

}
