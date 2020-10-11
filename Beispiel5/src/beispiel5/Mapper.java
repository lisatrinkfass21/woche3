/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel5;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Lisa
 */
public interface Mapper<S, T> {

    public T map(S s);

    default List<T> mapAll(List<S> list) {
        return list.stream()
                .map(a -> map(a))
                .collect(Collectors.toList());
    }

}
