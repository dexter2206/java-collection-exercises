package isogram;

import java.util.HashSet;
import java.util.Set;

public class Isogram {

    public static boolean isIsogram(String word) {
        // Metoda sprawdzająca czy słowo jest isogramem.
        // Isogram to słowo zawierające jedynie litery, spacje lub myślniki, przy czym każda litera musi występować
        // co najwyżej raz.
        // Pod uwagę bierzemy tylko słowa, które zawierają jedynie litery, myślniki i spacje.

        // Używamy słowa z zamienionymi wielkimi literami na małe.
        // W przeciwnym razie "Oko" byłoby isogramem, a "oko" nie
        word = word.toLowerCase();
        // Idea jest następująca - będziemy trzymali zbiór już odwiedzonych liter. Jeżeli kiedykolwiek okaże się,
        // że taki element już w zbiorze istniał, to znaczy, że słowo nie jest isogramem.
        Set<Character> seen = new HashSet<>(); // Zbiór na odwiedzone elementy
        Character c; // Znak, który będzie wczytywany
        for(int i = 0; i < word.length(); i++) { // Iterujemy po całym łańcuchu znaków
            c = word.charAt(i); // Pobieramy bieżący znak
            if(Character.isLetter(c)) { // przypadek: c jest literą
                if(seen.contains(c)) {// Jeżeli widzieliśmy już tę literę (czyli jest w zbiorze), to zwracamy false
                    return false;
                }
                seen.add(c);
            }
            else {
                // Przeciwny przypadek - c nie jest litera. Wtedy albo jest minusem lub spacją - i nie ma to wpływu na
                // kryterium bycia isogramem, albo zawiera niedopuszczaly znak - wtedy rzucamy wyjątkiem.
                if( c != '-' && c != ' ') {
                    throw new IllegalArgumentException("To nie jest dobre slowo.");
                }
            }
        }
        // Jeżeli do tej pory nie rzuciliśmy wyjątku ani nie zwróciliśmy false, to znaczy że nie było duplikatóœ lub
        // niepoprawnych znaków. Zwracamy więc true.
        return true;
    }
}
