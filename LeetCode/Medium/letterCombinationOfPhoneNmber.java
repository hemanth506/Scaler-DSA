// backtracking


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class letterCombinationOfPhoneNmber {
    List<String> respArr = new ArrayList<>();
    ArrayList<String> arr;
    int N;
    public void getAllCombination(int i, StringBuilder sb) {
        if(i == N) {
            respArr.add(sb.toString());
            return;
        }

        for(int j = 0; j < arr.get(i).length(); j++) {
            sb.append(arr.get(i).charAt(j));
            getAllCombination(i+1, sb);
            sb.deleteCharAt(i);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        N = digits.length();
        if(N == 0) {
            return new ArrayList<String>();
        }

        arr = new ArrayList<>();
        HashMap<Character, String> hm = getString();
        for(int i = 0; i < N; i++) {
            String curChar = hm.get(digits.charAt(i));
            arr.add(curChar);
        }

        System.out.println(arr);
        StringBuilder sb = new StringBuilder();
        getAllCombination(0, sb);
        System.out.println(respArr);
        return respArr;
    }

    public HashMap<Character, String> getString() {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        return hm;
    }

    public static void main(String[] args) {
        letterCombinationOfPhoneNmber lc = new letterCombinationOfPhoneNmber();
        // lc.letterCombinations("23");
        lc.letterCombinations("397");
    }
}
