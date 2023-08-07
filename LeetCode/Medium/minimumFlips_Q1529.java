class minimumFlips_Q1529 {
    public int minFlips(String target) {
        int N = target.length();

        char prevChar = target.charAt(0);
        int flips = 0;
        if(prevChar == '1') {
            flips = 1;
        }
        for(int i = 1; i < N; i++) {
            char curChar = target.charAt(i);
            System.out.println(prevChar + " " + curChar + " " + flips);
            if(prevChar != curChar) {
                flips += 1;
            }
            prevChar = curChar;
        }
        System.out.println(flips);
        return flips;
    }
    public static void main(String[] args) {
        minimumFlips_Q1529 mf = new minimumFlips_Q1529();
        String target = "101110101";
        // String target = "10110";
        // String target = "00000";

        // String target = "11000";

        mf.minFlips(target);
    }
}