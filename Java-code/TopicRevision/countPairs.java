// carry forward technique

public class countPairs {

    int checkPairs(String str) {
        char[] strArr = str.toCharArray();
        int N = strArr.length;

        int count = 0;
        int totalCount = 0;
        for(int i = N-1; i >= 0; i--) {
            
            if (strArr[i] == 'g') {
                count += 1;
            } else if (strArr[i] == 'a') {
                totalCount += count;
            }
        }

        return totalCount;
    }
    public static void main(String[] args) {
        countPairs ct = new countPairs();
        // String st = "baagdcag";
        String st = "adgagagfg";
        System.out.println(ct.checkPairs(st));
    }
}
