import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Pair {
  String name;
  int freq;

  Pair(String n, int f) {
    this.name = n;
    this.freq = f;
  }
}

public class SenderWithLargestWordCount_Q2284 {

  public String largestWordCount(String[] messages, String[] senders) {
    int N = messages.length;
    ArrayList<Pair> arr = new ArrayList<>();

    HashMap<String, Integer> hm = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int curWordCount = messages[i].split(" ").length;
      int curSenderPrevCount = hm.getOrDefault(senders[i], 0);
      hm.put(senders[i], curWordCount + curSenderPrevCount);
    }

    for (String name : hm.keySet()) {
      arr.add(new Pair(name, hm.get(name)));
    }

    Collections.sort(arr, new CustomSort());
    return arr.get(arr.size() - 1).name;
  }

  public static void main(String[] args) {
    SenderWithLargestWordCount_Q2284 sl = new SenderWithLargestWordCount_Q2284();
    String[] messages = { "Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree",
        "Hello userTwooo Nice day userThree" };
    String[] senders = { "Alic", "userTwo", "userThree", "Alic", "Alice" };

    // String[] messages = { "How is leetcode for everyone","Leetcode is useful for
    // practice" };
    // String[] senders = { "Bob","Charlie" };
    sl.largestWordCount(messages, senders);
  }
}

class CustomSort implements Comparator<Pair> {

  @Override
  public int compare(Pair o1, Pair o2) {
    if (o1.freq > o2.freq) {
      return 1;
    } else if (o1.freq < o2.freq) {
      return -1;
    }

    String o1Name = o1.name;
    String o2Name = o2.name;

    int N = o1Name.length();
    int M = o2Name.length();

    int limit = Integer.min(N, M);
    for (int i = 0; i < limit; i++) {
      if (o1Name.charAt(i) == o2Name.charAt(i)) {
        continue;
      }
      return o1Name.charAt(i) - o2Name.charAt(i);
    }

    return 0;
  }

}
