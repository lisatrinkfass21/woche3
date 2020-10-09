/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel2;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.random;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author Lisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int[] randomNumbers = new int[1000];
        String[] randomStrings = new String[10];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 100);
        }

        String charsl = "abcdefghijklmnopqrstuvwxyz";
        String charsu = charsl.toUpperCase();
        String num = "0123456789";
        String da = charsl + charsu + num;

        Random random = new Random();

        for (int e = 0; e < randomStrings.length; e++) {
            StringBuilder sb = new StringBuilder(10);
            for (int i = 0; i < 10; i++) {
                int ranChar = random.nextInt(da.length());
                char randChar = da.charAt(ranChar);
                sb.append(randChar);
            }
            randomStrings[e] = sb.toString();

        }

        for (int i = 0; i < randomStrings.length; i++) {
            System.out.println(randomStrings[i]);
        }

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

}
