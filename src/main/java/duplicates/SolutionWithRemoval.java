package duplicates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SolutionWithRemoval {
    // Rozwiązanie zadania z usuwaniem duplikatów z listy - wersja z dosłownym usuwaniem (a nie tworzeniem nowej listy)

    public static <T> void removeDuplicates(List<T> list) {
        // Usuwa duplikaty z listy, modyfikując listę w miejscu (nie tworząc nowej)
        Iterator<T> iterator = list.iterator(); // Iterator, którego użyjemy od przechodzenia po liście
        Set<T> seen = new HashSet<>();          // Zbiór, w którym będziemy umieszczali zobaczone elementy

        // Iterujemy po liście...
        while(iterator.hasNext()) {
            // Podejmujemy próbę dodania kolejnego elementu do zbioru
            if(!seen.add(iterator.next())) {
                // Jeżeli się nie udało, to znaczy, że element już tam był - czyli spotkaliśmy go wcześniej!
                // W takiej sytuacji usuwamy go z listy.
                iterator.remove();
            }
        }
        // Analiza zlożoności:
        // Pętla while wykonuje się tyle razy, ile elementów ma lista (powiedzmy, że n)
        // W każdym kroku wykonujemy operację add na HashSetcie, która ma złożoność O(1),
        // podobnie jak iterator.next()
        // Pozostałą częsc musimy rozdzielić na przypadki:
        // 1. Jeżeli list jest klasy LinkedList to usunięcie przy pomocy iteratora jest O(1)
        //    wtedy (nawet w pesymistycznym przypadku) cała złozoność to n * (O(1) + O(1) + O(1)) = O(n)
        // 2. Jeżeli list jest klasy ArrayList, to uusnięcie elementu ma złożoność O(n). Średnia zlożoność (zakładając
        //    że znacząca częśc listy to duplikaty) to n * (O(1) + O(1) + O(n)) = O(n^2)
    }
}
