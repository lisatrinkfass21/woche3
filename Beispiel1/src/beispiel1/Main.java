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

    public static void Main(String[] args) throws IOException {
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

    }

    public void sort1(LinkedList<Weapon> list) {
        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
    }

    public void sort2(LinkedList<Weapon> list) {
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
