package mergetwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeTwoIntegerLists {

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(new Integer[] {1, 3, 5, 11, 23});
        List<Integer> lst2 = Arrays.asList(new Integer[] {4, 5, 6, 15, 22, 24});
        System.out.println(merge(lst, lst2));
    }

    public static List<Integer> merge(List<Integer> first, List<Integer> second) {
        // Łączymy listy uporządkowane w jedną listę
        // Ponieważ znamy rozmiar połaczonej listy, wygodnie będzie nam użyć ArrayListy o ustalonym rozmiarze
        List<Integer> result = new ArrayList<>(first.size() + second.size()); // Tutaj będzie rezultat - połączona lista
        // Będziemy trzymali dwa wskaźniki (i - pierwsza lista, j - druga lista)
        // Zaczną one od 0 i będą się poruszały po listach.
        int i = 0, j = 0;
        Integer x, y;

        // Główna pętla - wykonujemy, dopóki któryś wskaźnik nie wyjdzie za odpowiadającą mu listę.
        // Będziemy pobierali po jednym elemencie z obu list - mniejszy z nich będzie tym, który musimy wstawić - wiemy
        // to, bo listy są uporządkowane.
        while(i < first.size() & j < second.size()) {
            // Pobieramy element pierwszej listy o indeksie i oraz element drugiej listy o indeksie j
            x = first.get(i);
            y = second.get(j);
            // Jeżeli pierwszy element jest mniejszy to wkładamy go do rezultatu. Skoro go wykorzystaliśmy, to posuwamy
            // się na tej liście dalej - czyli zwiększamy i o 1.
            if(x < y) {
                result.add(x);
                i += 1;
            } else {
                // Analogicznie postępujemy, jeśli nierówność jest odwrotna lub mamy równość.
                result.add(y);
                j += 1;
            }
        }

        // Po skończeniu głównej pętli któraś list ana pewno się jeszcze nie wyczerpała - druga na pewno się wyczerpała.
        // Wstawiamy więc elementy niewyczerpanej listy - użycie takiego warunku w pętli while sprawia, że dla wyczerpanej
        // listy ciało pętli nie wykona się ani raz.
        while(i < first.size()) {
            result.add(first.get(i));
            i++;
        }

        while(j < second.size()) {
            result.add(second.get(j));
            j++;
        }

        // zwracamy rezultat.
        return result;
        // Analiza złożoności:
        // Niech listy mają długośc n oraz m. Każdy z elementów musimy wstawić do nowej listy, przy czym wstawianie
        // ma złożoność O(1). Na każde wstawianie przypada co najwyżej jedno porównanie. Wszystko zależy więc tylko
        // od metody get naszych list. Dla ArrayList będzie to O(1), a nasz algorytm będzie miał zozoność
        // O(n+m) * O(1) = O(n+m). Dla LinkedList get ma złożoność liniową, algorytm miałby wtedy złożoność O((n+m)^2)
    }

    public static List<Integer> merge2(List<Integer> first, List<Integer> second) {
        // Łączenie list - sposób z iteratorami
        // Idea jest dokładnie taka sama, z niewielkimi detalami opisanymi niżej.

        // Zamiast indeksów - trzymamy iteratory
        Iterator<Integer> itFirst = first.iterator(), itSecond = second.iterator();
        // Trzymamy też dwie wartości - x oraz y (z pierwszej i drugiej listy odpowiednio.
        // jeżeli przejdziemyu za którąś listę, to odpowiadający jej Integer ustawimy na null.
        Integer x, y;

        // Lista na rezultat - tak jak poprzednio jest to ArrayList o ustawionej początkowej kolejności.
        List<Integer> result = new ArrayList<>(first.size() + second.size());

        // Pobiermay pierwsze elementy list.
        x = itFirst.next();
        y = itSecond.next();

        // Dopóki nie wyszliśmy za którąś z list:
        while(x != null & y != null) {
            // Robimy dokładnie to co w przypakdu z indeksami: wstawiamy mniejszy element i poruszamy się dalej na jego
            // liście. Jeżeli nie ma nowych elementów, to kolejny elemnet ustawiamy na null - dzięki temu wyjdziemy
            // z pętli.
            if(x < y) {
                result.add(x);
                x = itFirst.hasNext() ? itFirst.next() : null;
            }
            else {
                result.add(y);
                y = itSecond.hasNext() ? itSecond.next() : null;
            }
        }

        // Istotna różnica w stosunku do poprzedniej implementacji!!!
        // Liczby x oraz y pobieraliśmy za wczasu - ale na koniec pętli któraś z nich (ta, która nie jest nullem)
        // nie została wykorzystana. Musimy więc dodać ją teraz.
        if(x != null) {
            result.add(x);
        } else {
            result.add(y);
        }

        // Poniższe linie robią to co while'e na koniec poprzedniej implementacji - tylko jeden z forEachRemaining
        // doda jakiekolwiek elementy.
        // Przy okazji jest to równoważne do: itFirst.forEachRemaining(elem -> result.add(elem)
        // notacja z :: pozwala nam uniknąć pisania prostych lambd (które tylko wstawiają element jako argument do innej
        // metody) i zamiast tego przekazać od razu tę metodę.
        itFirst.forEachRemaining(result::add);
        itSecond.forEachRemaining(result::add);

        return result;

        // Analiza złożoności: znowu przechodzimy po obu listach i wykonujemy porównania: ale tym razem nie u↓żywamy get,
        // tylko bierzemy element z iteratora - co ma złożóność O(1). Zatem nasz algorytm ma teraz złożoność O(n+m)
    }
}
