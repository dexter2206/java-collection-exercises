package countletters;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {

    public static void main(String[] args) {
        // Przykład użycia
        System.out.println(countLetters("The quick brown fox jumped over a lazy dog"));
    }

    public static Map<Character, Integer> countLetters(String word) {
        // Zlicza znaki w słowie i zwraca mapę odwzorowującą znak na ilość wystąpień
        Map<Character, Integer> counts = new HashMap<>(); // Mapa na rezultat
        // Zamieniamy słowo na jego odpowiednik tylko z małymi literami - robimy to po to, żeby nie zliczać osobno
        // małych i dużych liter.
        word = word.toLowerCase();
        // Iterujemy po poszczególnych znakach w słowie
        for(Character c: word.toCharArray()) {
            // Sprawdzamy czy znak znajduje się w mapie
            if(!counts.containsKey(c)) {
                // ... i jeśli nie (co znaczy, że spotykamy go pierwszy raz) to wstawiamy go z wartością 1
                counts.put(c, 1);
            }
            else {
                // W przeciwnym razie pobieramy starą wartość, dodajemy do niej 1 i wstawiamy z powrotem z takim samym
                // kluczem.
                counts.put(c, counts.get(c)+1);
            }
        }
        // Zwracamy uzupełnioną przez nas mapę.
        return counts;
        // Analiza złożoności (n - dlugość słowa)
        // Ciało pętli for wykonuje się dokładnie jeden raz dla każdego z n znaków słowa word, czyli n razy.
        // W każdym kroku wykonujemy jedynie operacje put lub put i get na HashMapie. Ich złożoność ma rząd O(1)
        // zatem caly algorytm ma złożoność n * O(1) = O(n)
    }
}