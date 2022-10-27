public class countndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            System.out.println("n = " + n);
            return "1";
        }
        String curStr = countAndSay(n - 1) + " ";
        int len = curStr.length();
        System.out.println("n = " + n + " " + curStr + "===" + len);
        StringBuilder sb = new StringBuilder();
        int ct = 1;
        for (int i = 0; i < len - 1; i++) {
            if (curStr.charAt(i) == curStr.charAt(i + 1)) {
                ct += 1;
            } else {
                String curCt = Integer.toString(ct);
                sb.append(curCt);
                sb.append(curStr.charAt(i));
                ct = 1;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        countndSay ct = new countndSay();
        ct.countAndSay(6);
    }
}
