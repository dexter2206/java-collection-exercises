package fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // Klasa obliczająca elementy ciągu Fibonacciego używając memoizacji.
    // Idea jest nastepująca:
    // - wiemy, że obliczanie wyrazów ciągu rekurencyjnie spowodowałoby wielokrotne liczenie tego samego elementu
    // - zamiast więc liczyć za każdym razem, przecohwujemy już obliczone wartości, znacząco oszczędzając liczbę wywołań
    // - wartości przechowujemy w trzymanej w naszej instancji klasy mapie

    private Map<Integer, Integer> seen; // Mapa: numer wyrazu ciągu -> wartość

    public Fibonacci() {
        // Inicjalizujemy mapę i umieszczamy pierwsze dwa wyrazy ciągu - obydwa równe 1
        seen = new HashMap<>();
        seen.put(1, 1);
        seen.put(2, 1);
    }

    public Integer get(Integer n) {
        // Zwraca wartość n-tego wyrazu ciągu Fibonacciego
        if(seen.containsKey(n)) { // Sprawdzamy, czy już liczyliśmy ten wyraz. Jeśli tak - to wykorzystujemy już
                                  // raz obliczoną wartość.
            return seen.get(n);
        }
        // W przeciwnym razie, wywołujemy funkcję get rekurencyjnie dla mniejszych wyrazów.
        Integer fib = get(n-1) + get(n-2);
        // Policzoną wartość zachowujemy w mapie - może przyda się na potem.
        seen.put(n, fib);
        // Zwracamy wartość
        return fib;
        // Złożoność: O(1) jeżeli liczylismy już ten wyraz.
        // W najgorszym wypadku musimy policzyć wszystkie poprzednie, ale dla każdego wywołamy get(...) co najwyżej dwa razy
        // Zlożoność pesymistyczna to zatem n * O(2) = O(n).
    }
}
