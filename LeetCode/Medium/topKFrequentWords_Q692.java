import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import Medium.Pair_Str_Integer;

class CustomComparator implements Comparator<Pair_Str_Integer> {
    @Override
    public int compare(Pair_Str_Integer o1, Pair_Str_Integer o2) {
        if(o1.freq < o2.freq) {
            return 1;
        } else if (o1.freq == o2.freq) {
            return o1.word.compareTo(o2.word);
        }
        return -1;
    }
}

public class topKFrequentWords_Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        int N = words.length;
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int freq = hm.getOrDefault(words[i], 0) + 1;
            hm.put(words[i], freq);
        }
        // System.out.println(hm);

        ArrayList<Pair_Str_Integer> arr = new ArrayList<>();
        for(HashMap.Entry<String, Integer> mp: hm.entrySet()) {
            Pair_Str_Integer pr = new Pair_Str_Integer(mp.getValue(), mp.getKey());
            arr.add(pr);
        }

        Collections.sort(arr, new CustomComparator());
        // System.out.println(arr);
        List<String> StrArr = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            StrArr.add(arr.get(i).word);
            System.out.println(arr.get(i).word);
        }
        return StrArr;
    }
    public static void main(String[] args) {
        topKFrequentWords_Q692 tf = new topKFrequentWords_Q692();
        // String[] words = {"i","love","leetcode","i","love","coding"};
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 2;
        tf.topKFrequent(words, k);
    }
}
