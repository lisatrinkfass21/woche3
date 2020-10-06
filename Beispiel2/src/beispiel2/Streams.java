package beispiel2;

import java.util.Arrays;
import java.util.List;
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
        //implement this
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }

    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }

    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //implement this
    }
}
