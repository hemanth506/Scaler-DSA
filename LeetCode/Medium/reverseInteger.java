public class reverseInteger {
    public int reverse(int x) {
        String str = Integer.toString(x);
        int strLen = str.length();
        int endInd = 0;
        boolean isNegative = false;
        int maxVal = Integer.MAX_VALUE;
        int minVal = Integer.MIN_VALUE;
        if(str.charAt(0) == '-') {
            isNegative = true;
            endInd = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = strLen-1; i >= endInd; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
        long revInt = Long.parseLong(sb.toString());
        System.out.println(revInt);
        if(isNegative) {
            String revStr = '-' + Long.toString(revInt);
            revInt = Long.parseLong(revStr);
        }
        if(revInt > maxVal || revInt < minVal) {
            return 0;
        } 
        System.out.println(revInt);
        return (int) revInt;
    }
    public static void main(String[] args) {
        reverseInteger ri = new reverseInteger();
        // int x = -12345;
        int x = 964632435;

        ri.reverse(x);
    }
}
