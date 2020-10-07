/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Lisa
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Weapon> list = new LinkedList<>();
        list = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                s[0],
                CombatType.valueOf(s[1]),
                DamageType.valueOf(s[2]),
                Integer.parseInt(s[3]),
                Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),
                Integer.parseInt(s[6])
        ))
                .collect(Collectors.toList());

        Main.sort2(list);

        Printable pr = w -> System.out.println(w.getName() + " [" + w.getDamageType() + " = " + w.getDamage() + "]");
        list.forEach(a -> pr.print(a));

        System.out.println("---------------------+------------+-------------+---------+-------+---------+----------+");
        System.out.printf("%-20s", " | " + "Name");
        System.out.printf("%-13s", " | " + "CombatType");
        System.out.printf("%-13s ", " | " + "DamageType");
        System.out.printf("%-10s", " | " + "Damage");
        System.out.printf("%-8s", " | " + "Speed");
        System.out.printf("%-10s", " | " + "Length");
        System.out.printf("%-11s", " | " + "Value");
        System.out.printf("%-3s %n", " | ");

        Printable tab = e -> {
            System.out.println("---------------------+------------+-------------+---------+-------+---------+----------+");
            System.out.printf("%-20s", " | " + e.getName());  //printf -> Fortierung für Tabelle
            System.out.printf("%-13s", " | " + e.getCombatType()); //% x s -> Seitenabstand(negativ = linksbündig)
            System.out.printf("%-13s ", " | " + e.getDamageType()); // s fortiert Zeichenketten
            System.out.printf("%-10s", " | " + e.getDamage()); // %n steht für eine neue Zeile
            System.out.printf("%-8s", " | " + e.getSpeed());
            System.out.printf("%-10s", " | " + e.getMinStrength());
            System.out.printf("%-10s ", " | " + e.getValue());
            System.out.printf("%-3s %n", " | ");
        };
        list.forEach(a -> tab.print(a));
        System.out.println("---------------------+------------+-------------+---------+-------+---------+----------+");

    }

//Beispiel 1.2 fehlt noch UnitTest
//Beispiel 1.3 fehlt noch UnitTest
    public static void sort1(List<Weapon> list) {
        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
    }

    public static void sort2(List<Weapon> list) {
        list.sort((Weapon w1, Weapon w2) -> {
            if (w1.getCombatType().compareTo(w2.getCombatType()) == 0) {
                if (w1.getDamageType().compareTo(w2.getDamageType()) == 0) {
                    return w1.getName().compareTo(w2.getName());
                } else {
                    return w1.getDamageType().compareTo(w2.getDamageType());
                }
            }

            return w1.getCombatType().compareTo(w2.getCombatType());

        });

    }

}
