import java.util.*;

public class sortedPermutationRankRepeats {
    int mod = 1000003;
    public static int factorial(int fact, HashMap<Integer, Integer> mapFact, int mod) {
        if (fact == 1) {
            mapFact.put(fact, 1);
            return 1;
        }
        long newHmf = (factorial(fact - 1, mapFact, mod) * (long) fact)%mod;
        // System.out.println(newHmf);
        mapFact.put(fact, (int) newHmf);
        return (int)newHmf;
    }

    public int findRank(String A) {
        int N = A.length();
        
        HashMap<Integer, Integer> factorMap = new HashMap<Integer, Integer>();
        factorial(N, factorMap, mod);
        // System.out.println(" factorMaphm => " + factorMap);

        long totalRank = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = N - 1; i >= 0; i--) {
            char curChar = A.charAt(i);
            // System.out.println("curChar => " + curChar);
            if (hm.containsKey(curChar)) {
                int val = hm.get(curChar) + 1;
                hm.put(curChar, val);
            } else {
                hm.put(curChar, 1);
            }

            HashSet<Character> hs = new HashSet<Character>();
            int ct = 0;
            if (!hm.isEmpty()) {
                for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                    if (curChar > entry.getKey()) {
                        ct += 1;
                        hs.add(entry.getKey());
                    }
                }
            }

            if (ct != 0) {
                // System.out.println("Available HS => " + hs);
                int currentPermut = N-i-1;
                // System.out.println("i => " + currentPermut + " HMval => " + factorMap.get(currentPermut));
                long numeratorVal = factorMap.get(currentPermut);
                for(char charVal : hs) {
                    // decrementing
                    int tempVal = hm.get(charVal) - 1;
                    if(tempVal >= 1) {
                        hm.put(charVal, tempVal);
                    }

                    long temporVal = numeratorVal;
                    for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                        // denominatorVal = (denominatorVal%mod * factorMap.get(entry.getValue())%mod)%mod;
                        temporVal *= inverseNumber(factorMap.get(entry.getValue()));
                        temporVal = temporVal%mod;
                    }

                    // incrementing
                    if(tempVal >= 1) {
                        hm.put(charVal, tempVal+=1);
                    }

                    // System.out.println(numeratorVal + " / " + denominatorVal + " = " + (numeratorVal / denominatorVal));
                    // totalRank += numeratorVal / denominatorVal;

                    // System.out.println("temporVal : " + temporVal);
                    totalRank += temporVal;
                    totalRank %= mod;
                }
            }
            // System.out.println("================" + totalRank + "================");
        }
        totalRank += 1;
        // System.out.println(totalRank%mod);
        return (int)(totalRank%mod);
    }

    public int inverseNumber(int num) {
        return binPow(num, mod-2, mod);
    }
    
    // fast exponentiation method
    public int binPow(int num, int i, int mod2) {
        if(i == 0) {
            return 1;
        }
        long val = binPow(num, i/2, mod2);
        if(i%2 == 0) {
            return (int)((val * (long)val)%mod2);
        } else {
            return (int)(((val%mod2 * (long)val)%mod2 * num)%mod2);
        }
    }
    public static void main(String[] args) {
        sortedPermutationRankRepeats sp = new sortedPermutationRankRepeats();
        // String A = "aba"; // ans = 2
        // String A = "hfeeg"; // ans = 55
        // String A = "bca"; // ans = 4
        // String A = "bbbbaaaa"; // ans = 70
        String A = "sadasdsasassasas"; // ans = 208526

        // HashMap<Integer, Long> factorMap = new HashMap<Integer, Long>();
        // factorial(5, factorMap);
        sp.findRank(A);
    }
}



/*
 * public static int factorial(int fact, HashMap<Integer, Long> mapFact, int mod) {
        if (fact == 1) {
            mapFact.put(fact, 1L*1);
            return 1;
        }
        int newHmf = (factorial(fact - 1, mapFact, mod)%mod * fact%mod)%mod;
        mapFact.put(fact, 1L*newHmf);
        return newHmf;
    }

    public int findRank(String A) {
        int N = A.length();
        int mod = 1000003;

        HashMap<Integer, Long> factorMap = new HashMap<Integer, Long>();
        factorial(N, factorMap, mod);
        // System.out.println(" factorMaphm => " + factorMap);

        long totalRank = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = N - 1; i >= 0; i--) {
            char curChar = A.charAt(i);
            // System.out.println("curChar => " + curChar);
            if (hm.containsKey(curChar)) {
                int val = hm.get(curChar) + 1;
                hm.put(curChar, val);
            } else {
                hm.put(curChar, 1);
            }

            HashSet<Character> hs = new HashSet<Character>();
            int ct = 0;
            if (!hm.isEmpty()) {
                for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                    if (curChar > entry.getKey()) {
                        ct += 1;
                        hs.add(entry.getKey());
                    }
                }
            }

            if (ct != 0) {
                // System.out.println("Available HS => " + hs);
                int currentPermut = N-i-1;
                // System.out.println("i => " + currentPermut + " HMval => " + factorMap.get(currentPermut));
                long numeratorVal = factorMap.get(currentPermut);
                for(char charVal : hs) {
                    // decrementing
                    int tempVal = hm.get(charVal) - 1;
                    if(tempVal >= 1) {
                        hm.put(charVal, tempVal);
                    }

                    long denominatorVal = 1;
                    for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                        denominatorVal = (denominatorVal%mod * factorMap.get(entry.getValue())%mod)%mod;
                    }

                    // incrementing
                    if(tempVal >= 1) {
                        hm.put(charVal, tempVal+=1);
                    }

                    // System.out.println(numeratorVal + " / " + denominatorVal + " = " + (numeratorVal / denominatorVal));
                    totalRank += numeratorVal / denominatorVal;
                }
            }
            // System.out.println("================" + totalRank + "================");
        }
        totalRank += 1;
        // System.out.println(totalRank);
        return (int)totalRank%mod;
    }
 */

 