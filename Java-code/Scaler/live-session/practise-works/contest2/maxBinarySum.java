import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class maxBinarySum {
    public String addBinaryString(String A, String B) {
        int Alen = A.length();
        int Blen = B.length();
        long[] Aarr = new long[Alen];
        long[] Barr = new long[Blen]; 

        String[] splitA = A.split("");
        String[] splitB = B.split("");
        for(int i= 0; i< Alen; i++) {
            Aarr[i] = Integer.parseInt(splitA[i]);
        }
        for(int i= 0; i< Blen; i++) {
            Barr[i] = Integer.parseInt(splitB[i]);
        }

        // System.out.println(Arrays.toString(Aarr));
        // System.out.println(Arrays.toString(Barr));

        long N = Math.max(Alen, Blen);
        long Nmin = Math.min(Alen, Blen);
        long diff = N - Nmin;
        long[] newArrA = new long[(int) N];
        long[] newArrB = new long[(int) N];
        if (Alen == Blen) {
            newArrA = Aarr;
            newArrB = Barr;
        } else {
            for (int p = 0; p < 2; p++) {
                if (Alen != N) {
                    int l;
                    for(l = 0; l < diff; l++) {
                        newArrA[l] = 0;
                    }
                    for (int m = 0; m < Nmin; m++) {
                        newArrA[l] = Aarr[m];
                        l++;
                    }
                    newArrB = Barr;
                    break;
                } else if (Blen != N) {
                    int x;
                    for(x = 0; x < diff; x++) {
                        newArrB[x] = 0;
                    }
    
                    for (int y = 0; y < Nmin; y++) {
                        newArrB[x] = Barr[y];
                        x++;
                    }
                    newArrA = Aarr;
                    break;
                }
            }
        }

        long modNum = 0;
        long addVal = 1;
        ArrayList<Long> intArr = new ArrayList<Long>();
        for (long k = N - 1; k >= 0; k--) {
            addVal /= 2; 
            addVal += newArrA[(int) k]  + newArrB[(int) k];
            modNum = addVal % 2;
            intArr.add(modNum);
        }

        // System.out.println("addtional => " + (addVal / 2));
        if(addVal / 2  > 0) {
            intArr.add((long) 1);
        }

        int f = 0;
        int e = intArr.size() - 1;
        long temp = 0;
        while (f < e) {
            temp = intArr.get(f);
            intArr.set(f, intArr.get(e));
            intArr.set(e, temp);
            e--;
            f++;
        }
        // System.out.println(intArr);

        String finalString = "";
        for (int i = 0; i< intArr.size(); i++) {
            finalString += "" + intArr.get(i);
        }

        // System.out.println(finalString);
        return finalString;
    }

    public String flipBits(String C) {
        String newC = "";
        System.out.println("Before flip => " + C);
        // if intC = 0; 1 - 0 = 1
        // if intC = 1; 1 - 1 = 0
        for(int j = 0; j < C.length(); j++) {
            int intC = Integer.parseInt(String.valueOf(C.charAt(j)));
            newC += Integer.toString(1 - intC);
        }
        System.out.println("After flip  => " + newC);

        return newC;
    }

    public String solveNew(int A, int B, ArrayList<String> C) {
        int N = C.size();

        Collections.sort(C);
        System.out.println(C);
        
        for(int i = 0; i < B; i++) {
            if(C.get(i).charAt(0) == '0') {
                System.out.println(C.get(i));
                String newC = flipBits(C.get(i));
                C.set(i, newC);
            } else {
                break;
            }
        }
        
        String sum = "";
        for(int i = 0; i < N; i++) {
            sum = addBinaryString(C.get(i), sum);
        }
        System.out.println(sum);

        return sum;
    } 
    public static void main(String[] args) {
        maxBinarySum mb = new maxBinarySum();
        // int A = 5;
        // int B = 1;
        // ArrayList<String> C = new ArrayList<String>(Arrays.asList("0111", "1010", "1001", "0001", "0010"));
        
        // int A = 2;
        // int B = 1;
        // ArrayList<String> C = new ArrayList<String>(Arrays.asList("11", "01"));

        int A = 4;
        int B = 2;
        ArrayList<String> C = new ArrayList<String>(Arrays.asList("1111111", "0101000", "1011010", "0111001"));
        
        // int A = 8;
        // int B = 2;
        // ArrayList<String> C = new ArrayList<String>(Arrays.asList("1","1","0","0","1","1","1","1"));
        
        // mb.solve(A, B, C);
        mb.solveNew(A, B, C);

    }
}
