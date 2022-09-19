
public class basics {
    public int sumNnatural(int num) {
        if(num == 1) {
            return 1;
        }
        return sumNnatural(num - 1) + num;
    }

    public void NAscending(int num) {
        if(num == 1) {
            System.out.println("Descending => " + num);
            System.out.println("Ascending => " + num);
            return;
        }
        System.out.println("Descending => " + num);
        NAscending(num - 1);
        System.out.println("Ascending => " + num);
    }

    public void NDescending(int num) {
        if(num == 1) {
            System.out.println(num);
            return;
        }
        System.out.println(num);
        NDescending(num - 1);
    }

    public boolean checkPalindrome(String str, int s, int e) {

        if (s > e) {
            return true;
        }
        if(str.charAt(s) != str.charAt(e)) {
            return false;
        }
        
        return checkPalindrome(str, s + 1, e - 1);
    }

    public int sumOfDigits(int num) {
        if(num == 1) {
            return 1;
        }
        return sumOfDigits(num/10) + num % 10;
    }

    public int powVal(int A, int N) {
        if(N == 1) {
            return A;
        }
        int val = powVal(A, N/2);
        if(N%2 == 0) {
            return val * val;
        } else {
            return val * val * A;
        }
    }
    
    public static void main(String[] args) {
        basics bc = new basics();

        int A = bc.sumNnatural(10);
        // System.out.println(A);

        bc.NAscending(10);
        // bc.NDescending(10);

        String str = "dooddooad";
        int s = 1;
        int e = 6;
        // System.out.println(bc.checkPalindrome(str, s, e));

        int sumN = 1234;
        int sumV = bc.sumOfDigits(sumN);
        // System.out.println(sumV);
        
        int val = 2;
        int pow = 5;
        // System.out.println(bc.powVal(val, pow));
    }
}
