
public class addBinaryString {
    public String addBinary(String A, String B) {
        int NA = A.length();
        int NB = B.length();

        if (NA != NB) {
            if (NA > NB) {
                int diff = NA - NB;
                for(int i = 0; i < diff; i++) {
                    B = "0" + B;
                }
            } else {
                int diff = NB - NA;
                for(int i = 0; i < diff; i++) {
                    A = "0" + A;
                }
            }
        }
        System.out.println(A + " " + B);

        int N = A.length();
        StringBuilder newStr = new StringBuilder();
        int divV = 0;
        for(int i = N - 1; i >= 0; i--) {
            int AInt = Character.getNumericValue(A.charAt(i));
            int BInt = Character.getNumericValue(B.charAt(i));
            System.out.println(i + " " + AInt + " " + BInt);
            int modV = (divV / 2) + AInt + BInt;
            newStr.append(Integer.toString(modV % 2));
            divV = modV;
        }
        if(divV > 1) {
            newStr.append("1");
            N += 1;
        }

        System.out.println(newStr);
        System.out.println(newStr.reverse());
        return newStr.reverse().toString();
    }
    public static void main(String[] args) {
        addBinaryString ab = new addBinaryString();
        // String A = "100";
        // String B = "11";

        // String A = "1010110111001101101000";
        // String B = "1000011011000000111100110";

        String A = "1110101";
        String B = "1111011";

        ab.addBinary(A, B);
    }
}
// 1001110001110111001010101
// 1001110001111010101001110
