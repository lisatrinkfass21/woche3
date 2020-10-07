/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel.pkg4;

import java.util.stream.IntStream;

/**
 *
 * @author Lisa
 */
public class Beispiel4 {

    public static void main(String[] args) {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(a -> a % 2 != 0)
                .map(b -> b = b * b)
                .reduce(0, (c, d) -> c + d);

        System.out.println(result);
    }

}
