package io.github.drw.rules.characters.names;

import io.github.drw.rules.characters.Character;
import io.github.drw.rules.dice.Dice;
import io.github.drw.rules.io.FileReader;
import io.github.drw.rules.io.NameData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The model for GeneratorController.
 *
 * @author dr-wilkinson
 */
public class NameGenerator {

    private static Random random;
    private static NameData.Gender gender;

    private static Map<String, List<NameData>> maleNames;
    private static Map<String, List<NameData>> femaleNames;
    private static Map<String, List<NameData>> lastNames;

    private static List<NameData> names = null;

    private static Character character;

    static {
        random = new Random(System.currentTimeMillis());
        names = new FileReader("names", "names.txt").readNameDataFile();
        maleNames = init(new HashMap<>());
        femaleNames = init(new HashMap<>());
        lastNames = init(new HashMap<>());
        for (NameData nameData : names) {
            filter(nameData);
        }
    }

    private static Map<String, List<NameData>> init(Map<String, List<NameData>> map) {
        String[] keys = new String("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z").split(",");
        for (String key : keys) {
            map.put(key, new ArrayList<>());
        }
        return map;
    }

    private static NameData filter(NameData nameData) {
        if (nameData.getGender().equals(NameData.Gender.FEMALE)) {
            insert(femaleNames, nameData);
        }
        if (nameData.getGender().equals(NameData.Gender.MALE)) {
            insert(maleNames, nameData);
        }
        if (nameData.canBeLastName()) {
            insert(lastNames, nameData);
        }
        return nameData;
    }

    private static void insert(Map<String, List<NameData>> map, NameData nameData) {
        String character = String.valueOf(nameData.getValue().charAt(0));
        for (String key : map.keySet()) {
            if (character.equals(key)) {
                List<NameData> list = map.get(key);
                list.add(nameData);
                break;
            }
        }
    }

    /**
     * Takes the supplied {@link Character}, gives it a {@link Name} filtered by
     * {@link Gender} and returns the named Character.
     * <p>
     * If the supplied Character's Name has not been set, then an entirely
     * random name is generated.</p>
     * <p>
     * If the Name has been set, then only not {@code null} values are named
     * randomly. For example: A Character with its Name set with first part
     * "Bobby" will have random middle and last parts generated.</p>
     *
     * @param c The Character to Name.
     * @returnThe named Character.
     */
    public static Character generate(Character c) {
        character = c;
        gender = NameData.Gender.convert(character.getGender());
        int totalParts = totalParts();
        Map<String, List<NameData>> firstAndMiddleNames = filter(gender);
        List<String> keys = new ArrayList<>();
        while (keys.size() < totalParts - 1) {
            int index = random.nextInt(26);
            String key = (String) firstAndMiddleNames.keySet().toArray()[index];
            if (!keys.contains(key)) {
                if (!firstAndMiddleNames.get(key).isEmpty()) {
                    keys.add(key);
                }
            }
        }
        while (keys.size() < totalParts) {
            int index = random.nextInt(26);
            String key = (String) lastNames.keySet().toArray()[index];
            if (!keys.contains(key)) {
                if (!lastNames.get(key).isEmpty()) {
                    keys.add(key);
                }
            }
        }
        List<NameData> namesData = null;
        NameData nameData = null;
        String part = null;
        if (character.getName().getFirst() == null) {
            namesData = firstAndMiddleNames.get(keys.get(0));
            nameData = namesData.get(random.nextInt(namesData.size()));
            part = nameData.getValue();
            character.getName().setFirst(part);
            keys.remove(0);
        }
        if (character.getName().getLast() == null) {
            namesData = lastNames.get(keys.get(keys.size() - 1));
            nameData = namesData.get(random.nextInt(namesData.size()));
            part = nameData.getValue();
            character.getName().setLast(part);
            keys.remove(keys.size() - 1);
        }
        if (character.getName().getMiddle() == null) {
            StringBuilder sb = new StringBuilder();
            for (String key : keys) {
                namesData = firstAndMiddleNames.get(key);
                nameData = namesData.get(random.nextInt(namesData.size()));
                part = nameData.getValue();
                sb.append(part).append(" ");
            }
            String middle = sb.toString().trim();
            character.getName().setMiddle(middle);
        }
        return character;
    }

    private static int totalParts() {
        int total = 2;
        int result = Dice.roll(2);
        if (result <= 2) {
            total += 3;
        } else if (result <= 4) {
            total += 2;
        } else if (result <= 8) {
            total += 1;
        }
        return total;
    }

    private static Map<String, List<NameData>> filter(NameData.Gender gender) {
        Map<String, List<NameData>> map = null;
        if (gender != null) {
            if (gender.equals(NameData.Gender.MALE)) {
                map = maleNames;
            } else if (gender.equals(NameData.Gender.FEMALE)) {
                map = femaleNames;
            } else {
                map = random.nextBoolean() ? maleNames : femaleNames;
            }
        }
        return map;
    }

}
