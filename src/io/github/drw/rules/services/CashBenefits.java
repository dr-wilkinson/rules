/*
 * CashBenefits.java
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
package io.github.drw.rules.services;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.dice.Dice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates the cash benefits available to {@link Character}s when they
 * leave a {@link Service}.
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class CashBenefits {

    private static final Map<String, Table> tables = new HashMap<>();

    private static List<Integer> cash = new ArrayList<>();

    static {
        tables.put(new Navy().name(), new Table());
        tables.put(new Marines().name(), new Table());
        tables.put(new Army().name(), new Table());
        tables.put(new Scouts().name(), new Table());
        tables.put(new Merchants().name(), new Table());
        tables.put(new Other().name(), new Table());

        Table navy = tables.get(new Navy().name());
        navy.addAmount(1000);
        navy.addAmount(5000);
        navy.addAmount(5000);
        navy.addAmount(10000);
        navy.addAmount(20000);
        navy.addAmount(50000);
        navy.addAmount(50000);

        Table marines = tables.get(new Marines().name());
        marines.addAmount(2000);
        marines.addAmount(5000);
        marines.addAmount(5000);
        marines.addAmount(10000);
        marines.addAmount(20000);
        marines.addAmount(30000);
        marines.addAmount(40000);

        Table army = tables.get(new Army().name());
        army.addAmount(2000);
        army.addAmount(5000);
        army.addAmount(10000);
        army.addAmount(10000);
        army.addAmount(10000);
        army.addAmount(20000);
        army.addAmount(30000);

        Table scouts = tables.get(new Scouts().name());
        scouts.addAmount(20000);
        scouts.addAmount(20000);
        scouts.addAmount(30000);
        scouts.addAmount(30000);
        scouts.addAmount(50000);
        scouts.addAmount(50000);
        scouts.addAmount(50000);

        Table merchants = tables.get(new Merchants().name());
        merchants.addAmount(1000);
        merchants.addAmount(5000);
        merchants.addAmount(10000);
        merchants.addAmount(20000);
        merchants.addAmount(20000);
        merchants.addAmount(40000);
        merchants.addAmount(40000);

        Table other = tables.get(new Other().name());
        other.addAmount(1000);
        other.addAmount(5000);
        other.addAmount(10000);
        other.addAmount(10000);
        other.addAmount(10000);
        other.addAmount(50000);
        other.addAmount(100000);

    }

    private static void reset() {
        cash = new ArrayList<>();
    }

    public static void process(Service service, int rolls, boolean addOneOption) {
        reset();
        Table table = tables.get(service.name());
        for (int i = 0; i < rolls; i++) {
            rollAmount(table, addOneOption);
        }
    }

    private static void rollAmount(Table table, boolean addOneOption) {
        int result = Dice.roll(1);
        if (addOneOption) {
            if (Dice.roll(1) <= 3) {
                result++;
            }
        }
        Integer amount = table.getAmount(result);
        cash.add(amount);
    }

    public static void apply(Character character) {
        int total = 0;
        for (Integer amount : cash) {
            total += amount;
        }
        character.getCredits().deposit(total);
    }

    private static class Table {

        private Map<Integer, Integer> map = new HashMap<>();

        void addAmount(Integer amount) {
            int key = map.size() + 1;
            map.put(key, amount);
        }

        Integer getAmount(int key) {
            return map.get(key);
        }

    }

}
