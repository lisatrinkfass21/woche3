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

    private List<Weapon> list = new LinkedList<>();

    public static void Main(String[] args) throws IOException {
        Main main = new Main();
        main.list = Files.lines(new File("weapons.csv").toPath())
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

    public List<Weapon> getList() {
        return list;
    }

    public void List<Weapon

    > sortList() {
        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
    }

;

}
