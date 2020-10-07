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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lisa
 */
public class MainTest {

    private List<Weapon> list = new LinkedList<Weapon>();

    public MainTest() {
    }

    @Before
    public void setUp() throws IOException {
        readFile();
    }

    @After
    public void tearDown() {
        list.clear();
    }

    /**
     * Test of main method, of class Main.
     */
    /**
     * Test of sort1 method, of class Main.
     */
    @Test
    public void testSort1() {
        System.out.println("sort1");
        List<Weapon> expectedResult = new LinkedList<Weapon>();
        Main.sort1(list);
        expectedResult.add(new Weapon("Carsomyr", CombatType.MELEE, DamageType.SLASHING, 17, 5, 14, 20000));
        expectedResult.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.BLUNT, 16, 1, 25, 15500));
        expectedResult.add(new Weapon("Flail of Ages", CombatType.MELEE, DamageType.BLUNT, 13, 4, 13, 4500));
        expectedResult.add(new Weapon("The Burning Earth", CombatType.MELEE, DamageType.SLASHING, 12, 4, 5, 4750));
        expectedResult.add(new Weapon("Daystar", CombatType.MELEE, DamageType.SLASHING, 12, 3, 6, 10000));
        expectedResult.add(new Weapon("Varscona", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        expectedResult.add(new Weapon("Boomerang Dagger", CombatType.RANGED, DamageType.PIERCING, 10, 1, 3, 3500));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("Kundane", CombatType.MELEE, DamageType.SLASHING, 8, 0, 5, 4000));
        expectedResult.add(new Weapon("Dagger of Venom", CombatType.MELEE, DamageType.PIERCING, 6, 0, 3, 10000));
        expectedResult.add(new Weapon("Strong Arm", CombatType.RANGED, DamageType.MISSILE, 3, 5, 19, 5500));
        expectedResult.add(new Weapon("Heartseeker", CombatType.RANGED, DamageType.MISSILE, 2, 4, 18, 7800));
        expectedResult.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));
        expectedResult.add(new Weapon("Broken Weapon", CombatType.NONE, DamageType.NONE, 0, 0, 0, 0));

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).toString(), list.get(i).toString());

        }
    }

    /**
     * Test of sort2 method, of class Main.
     */
    @Test
    public void testSort2() {
        System.out.println("sort2");
        List<Weapon> expectedResult = new LinkedList<Weapon>();
        Main.sort2(list);
        expectedResult.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.BLUNT, 16, 1, 25, 15500));
        expectedResult.add(new Weapon("Flail of Ages", CombatType.MELEE, DamageType.BLUNT, 13, 4, 13, 4500));
        expectedResult.add(new Weapon("Dagger of Venom", CombatType.MELEE, DamageType.PIERCING, 6, 0, 3, 10000));
        expectedResult.add(new Weapon("Carsomyr", CombatType.MELEE, DamageType.SLASHING, 17, 5, 14, 20000));
        expectedResult.add(new Weapon("Daystar", CombatType.MELEE, DamageType.SLASHING, 12, 3, 6, 10000));
        expectedResult.add(new Weapon("Kundane", CombatType.MELEE, DamageType.SLASHING, 8, 0, 5, 4000));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        expectedResult.add(new Weapon("The Burning Earth", CombatType.MELEE, DamageType.SLASHING, 12, 4, 5, 4750));
        expectedResult.add(new Weapon("Varscona", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        expectedResult.add(new Weapon("Broken Weapon", CombatType.NONE, DamageType.NONE, 0, 0, 0, 0));
        expectedResult.add(new Weapon("Heartseeker", CombatType.RANGED, DamageType.MISSILE, 2, 4, 18, 7800));
        expectedResult.add(new Weapon("Strong Arm", CombatType.RANGED, DamageType.MISSILE, 3, 5, 19, 5500));
        expectedResult.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));
        expectedResult.add(new Weapon("Boomerang Dagger", CombatType.RANGED, DamageType.PIERCING, 10, 1, 3, 3500));

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).toString(), list.get(i).toString());

        }

    }

    public void readFile() throws IOException {
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
