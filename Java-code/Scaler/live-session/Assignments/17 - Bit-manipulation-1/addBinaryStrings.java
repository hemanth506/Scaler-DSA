import java.util.ArrayList;

public class addBinaryStrings {

    public String addBinary(String A, String B) {
        int Alen = A.length();
        int Blen = B.length();
        int[] Aarr = new int[Alen];
        int[] Barr = new int[Blen]; 

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

        int N = Math.max(Alen, Blen);
        int Nmin = Math.min(Alen, Blen);
        int diff = N - Nmin;
        int[] newArrA = new int[N];
        int[] newArrB = new int[N];
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

        int modNum = 0;
        int addVal = 1;
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        for (int k = N - 1; k >= 0; k--) {
            addVal /= 2; 
            addVal += newArrA[k]  + newArrB[k];
            modNum = addVal % 2;
            intArr.add(modNum);
        }

        // System.out.println("addtional => " + (addVal / 2));
        if(addVal / 2  > 0) {
            intArr.add(1);
        }
        

        int f = 0;
        int e = intArr.size() - 1;
        int temp = 0;
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

        return finalString;
    }
    
    
    public static void main(String[] args) {
        addBinaryStrings addB = new addBinaryStrings();
        // String A = "10110";
        // String B = "111";

        // String A = "11011";
        // String B = "11010";

        // String A = "1010110111001101101000";
        // String B = "1000011011000000111100110";

        String A = "1";
        String B = "1";


        System.out.println(addB.addBinary(A, B));

    }
}
