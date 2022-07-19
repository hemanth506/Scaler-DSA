public class numberOfOnesBite {
    public int numSetBits(int A) {
        int B = 0;
        int ct = 0;
        while(A > 0) {
            B = A % 2;
            if(B == 1)
                ct += 1;
            // System.out.println("Mod => " + B);
            A = A / 2;
        }
        return ct;
    }
    public static void main(String[] args) {
        numberOfOnesBite bites = new numberOfOnesBite();
        int A = 101;
        System.out.println(bites.numSetBits(A));
    }
}
