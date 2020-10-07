package beispiel2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public double average(int[] numbers) {
        double result = Arrays.stream(numbers)
                .reduce(0, (a, b) -> a + b) / (double) numbers.length;

        return result;
    }

    public List<String> upperCase(String[] strings) {
        List<String> arr = Arrays.asList(strings).stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return arr;

    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream()
                .min(Comparator.comparing(Weapon::getDamage))
                .orElse(weapons.get(0));
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream()
                .max(Comparator.comparing(Weapon::getMinStrength))
                .orElse(weapons.get(0));
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream()
                .filter((a) -> a.getDamageType() == DamageType.MISSILE)
                .collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream()
                .max(Comparator.comparing((Weapon w) -> w.getName().length()))
                .orElse(weapons.get(0));

    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream()
                .map(Weapon::getName)
                .collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(Weapon::getSpeed)
                .toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(Weapon::getValue)
                .reduce(0, (a, b) -> a + b);
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(Weapon::hashCode)
                .reduce(0, (a, b) -> a + b);
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream()
                .mapToDouble(Weapon::getValue)
                .forEach(a -> a.setValue((int) (a.getValue() * 1.1)));
    }
}
