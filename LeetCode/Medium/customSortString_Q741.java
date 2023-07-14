import java.util.HashMap;

public class customSortString_Q741 {
    public String customSortString(String order, String s) {
        int N = order.length();
        int M = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < M; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        System.out.println(hm);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(hm.containsKey(order.charAt(i))) {
                int charCt = hm.get(order.charAt(i));
                for(int j = 0; j < charCt; j++) {
                    sb.append(order.charAt(i));
                }
                hm.remove(order.charAt(i));
            }
        }
        System.out.println(hm);

        for(HashMap.Entry<Character,Integer> iterMap : hm.entrySet()) {
            for(int i = 0; i < iterMap.getValue(); i++) {
                sb.append(iterMap.getKey());
            }
        }
        System.out.println(sb);
        return sb.toString();   
    }
    public static void main(String[] args) {
        customSortString_Q741 cs = new customSortString_Q741();
        String order = "cbafg";
        String s = "abcd";
        cs.customSortString(order, s);
    }
}
