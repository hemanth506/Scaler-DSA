// Some times brute force will be the optimized solution.
import java.util.ArrayList;
import java.util.List;

public class wordsWithinTwoEditsOfDictionary_Q2452 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> respArr = new ArrayList<>();

        outer: for (String q : queries) {
            for (String d : dictionary) {
                int c = 0;
                for (int i = 0; i < q.length() && c < 3; i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        c++;
                    }
                }
                if (c < 3) {
                    respArr.add(q);
                    continue outer;
                }
            }
        }
        System.out.println(respArr);
        return respArr;
    }

    public static void main(String[] args) {
        wordsWithinTwoEditsOfDictionary_Q2452 ww = new wordsWithinTwoEditsOfDictionary_Q2452();
        String[] queries = { "word", "note", "ants", "wood", "kord" };
        String[] dictionary = { "wood", "joke", "moat" };
        ww.twoEditWords(queries, dictionary);
    }
}
