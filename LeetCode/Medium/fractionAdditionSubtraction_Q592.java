import java.util.ArrayList;

public class fractionAdditionSubtraction_Q592 {
    public String fractionAddition(String expression) {
        int N = expression.length();
        ArrayList<Integer> numerator = new ArrayList<>();
        ArrayList<Integer> denominator = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (expression.charAt(i) == '/') {
                StringBuilder numSb = new StringBuilder();
                for (int j = i - 1; j >= 0; j--) {
                    if (expression.charAt(j) == '+' || expression.charAt(j) == '-') {
                        if (expression.charAt(j) == '-') {
                            numSb.append(expression.charAt(j));
                        }
                        break;
                    } else {
                        numSb.append(expression.charAt(j));
                    }
                }
                numSb.reverse();
                numerator.add(Integer.parseInt(numSb.toString()));

                StringBuilder denoSb = new StringBuilder();
                for (int k = i + 1; k < N; k++) {
                    if (expression.charAt(k) == '+' || expression.charAt(k) == '-') {
                        break;
                    } else {
                        denoSb.append(expression.charAt(k));
                    }
                }

                denominator.add(Integer.parseInt(denoSb.toString()));
            }
        }
        System.out.println(numerator);
        System.out.println(denominator);

        int lcmVal = denominator.get(0);
        for (int i = 1; i < denominator.size(); i++) {
            lcmVal = (lcmVal * denominator.get(i)) / gcd(lcmVal, denominator.get(i));
        }
        System.out.println("lcmVal = " + lcmVal);

        int numer = 0;
        for (int i = 0; i < denominator.size(); i++) {
            int val = lcmVal / denominator.get(i);
            numer += (val * numerator.get(i));
        }
        System.out.println("numer = " + numer);

        System.out.println("============");

        
        StringBuilder sb = new StringBuilder();
        if (numer != 0) {
            int gcdV = gcd(lcmVal, numer);
            System.out.println("gcdV = " + gcdV);
            int den = lcmVal / gcdV;
            int num = numer / gcdV;
            if(den < 0) {
                num = num * (-1);
            }
            sb.append(num);
            sb.append("/");
            if(den < 0) {
                den = Math.abs(den);
            }
            sb.append(den);
        } else {
            sb.append(numer);
            sb.append("/");
            sb.append(1);
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    private int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        fractionAdditionSubtraction_Q592 fc = new fractionAdditionSubtraction_Q592();
        // String expression = "-1/2+1/2+1/3";
        // String expression = "1/3-1/2";
        // String expression = "-1/2+1/2";
        // String expression = "-1/2+1/9";
        // String expression = "5/3+1/3";
        String expression = "1/2-4/1-4/3+1/2-5/1";
        fc.fractionAddition(expression);
    }
}
