package scrabble;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ScrabbleScoreCounter {

    private static Map<Integer, Integer> scores;

    static {
        Map<Integer, Integer> tmpScores = new HashMap<>();

        fillScore(tmpScores, "AEIOULNRST", 1);
        fillScore(tmpScores, "DG", 2);
        fillScore(tmpScores, "BCMP", 3);
        fillScore(tmpScores, "FHVWY", 4);
        fillScore(tmpScores, "K", 5);
        fillScore(tmpScores, "JX", 8);
        fillScore(tmpScores, "QZ", 10);
        scores = Collections.unmodifiableMap(tmpScores);
    }

    private static void fillScore(Map<Integer, Integer> scores, String letters, int point) {
        letters.chars().forEach((code) -> scores.put(code, point));
    }

    public int countScore(String word) {
        if(word.chars().allMatch(scores::containsKey)) {
            return word.chars().map(scores::get).sum();
        }
        throw new IllegalArgumentException("There was some character with no score assigned. Is this really a word?");
    }
}
