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

    public MainTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    /**
     * Test of sortMyList method, of class Main.
     */
    @Test
    public void testSortMyList() throws IOException {
        System.out.println("sortMyList");
        LinkedList<beispiel1.Weapon> list = null;
        Main instance = new Main();
        list = (LinkedList<Weapon>) instance.getList();
        list.sort(cmprtr);

        LinkedList<beispiel1.Weapon> expResult = null;
        LinkedList<beispiel1.Weapon> result = instance.sortMyList(list);
        assertEquals(expResult, result);

    }

}
