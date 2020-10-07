/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel3;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Lisa
 */
public class Beispiel3 {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(7);
        list.add(-8);
        list.add(0);
        //   list.add(null);

        List<String> list2 = new LinkedList<String>();
        list2.add("abc");
        list2.add("asdf");
        list2.add("sd");
        list2.add(" ");
        list2.add("adfljaldf");

        final Predicate<Integer> isEven = e -> e % 2 == 0;
        final Predicate<Integer> isPositive = e -> e > 0;
        final Predicate<Integer> isNumberNull = e -> e == 0;
        final Predicate<Integer> isNull = e -> e == null;
        final Predicate<String> isShortWord = e -> e.length() < 4;

        list.stream()
                .filter(isEven)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " ist gerade"));

        list.stream()
                .filter(isPositive)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " ist positiv"));

        list.stream()
                .filter(isNumberNull)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " hat den Wert Null"));

        list.stream()
                .filter(isNull)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println("Wert ist null"));

        list2.stream()
                .filter(isShortWord)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " hat weniger als 4 Buchstaben"));

        list.stream()
                .filter(isPositive.and(isEven))
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " ist positiv und gerade"));

        list.stream()
                .filter(isPositive.and(isEven.negate()))
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e + " ist positiv und ungerade"));

    }

}
