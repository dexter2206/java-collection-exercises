package zigzag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZag {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(new Integer[] {5,2,1,3,4,5,2,0});
        makeZigZag(lst);
        System.out.println(lst);
    }

    public static void makeZigZag(List<Integer> lst) {
        // Robi zygzag z listy, modyfikując ją w miejscu
        if(lst.size() <= 2) {
            return;
        }
        // Idea jest następująca - znajdziemy ułożenie początkowych elementów listy
        // a kolejne pary będziemy ustawiali w przeciwnym porządku.
        // Ułożenie elementów (większy - mniejszy lub większy - mniejszy) jednoznacznie
        // określa znak róznicy między nimi - dlatego go obliczamy.
        Integer order = lst.get(1) - lst.get(0);
        // Jedyny szczególny przypadek to sytuacja gdy elementy są równe - w takiej sytuacji
        // sztucznie ustawiamy order = 1, czyli zakładamy, że lista startuje z pozycji
        // mniejszy - większy.
        if(order == 0) {
            order = 1;
        }
        // Iterujemy po parach elementów. Zaczynamy od pary o indeksach 1 i 2, bo para
        // o indeksach 0 i 1 jest już ułożona. Ponieważ i będzie pierwszym indeksem pary
        // to iterujemy tylko dopóki i < lst.size() - 1 (bo to ostatni element, który ma po
        // sobie element do pary).
        for(int i = 1; i < lst.size() - 1; i++) {
            // Sprawdzamy porządek elementów i mnożymy go przez ostatni porządek jaki mielismy
            // na liście i badamy jego znak (czy jest większy od 0). Mamy dwa przypadki:
            // 1. Porządki są takie same - mamy mnożenie dwóch liczb o tym samym znaku warunek w
            // ifie sprawdza właśnie ten przypadek. W takiej sytuacji zamieniamy liczby miejscami.
            // 2. Porządki są przeciwne, lub nowa para jest złożona z takich samych elementów.
            // W takiej sytuacji nic nie musimy robić - elementy są już dobrze ułożone.
            if( (lst.get(i+1) - lst.get(i)) * order > 0) {
                swap(lst, i, i+1);
            }
            // Niezależnie od tego czy if się wykonał czy nie, zmieniamy order na przeciwną liczbę -
            // dzięki temu w kolejnej iteracji nasz if będzie wykrywał odpowiedni porządek.
            order = -order;
        }

        // Analiza złożoności: Przechodzimy po liście jeden raz, za każdym razem pobierając dwa elementy przy pomocy metody
        // get. Używamy też metody swap, która jest O(get). Nasz algorytm ma zatem złozoność n * 2 * O(get) gdzie O(get)
        // to złożoność metody get naszej listy. Dla ArrayList otrzymujemy więc n * 2 * O(1), a dla LinkedList
        // otrzymujemy n * 2 * O(n) = O(n^2)
    }

    public static void swap(List<Integer> lst, int i, int j) {
        // Zamienia elementy w liście miejscami.
        // Wykonujemy jedynie operacje get i set (i przypisania).
        // Dla ArrayList metoda ta ma więc złożóność O(1) (tak jak get i set),
        // a dla LinkedList O(n).
        Integer tmp;
        tmp = lst.get(i);
        lst.set(i, lst.get(i+1));
        lst.set(i+1, tmp);
    }
}
