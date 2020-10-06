/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel2;

import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author Lisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] randomNumbers = new int[1000];
        String[] randomStrings = new String[10];
        byte[] arr = new byte[10];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < randomStrings.length; i++) {
            new Random().nextBytes(arr);
            randomStrings[i] = new String(arr, Charset.forName("UTF-8"));

        }

    }

}
