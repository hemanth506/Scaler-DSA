import java.util.HashMap;

public class anotherCoinProblem {
    public int solve(int A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int temp = 1;
        int times = 0;
        while (temp*5 > 0) {
            hm.put(times, temp);
            temp *= 5;
            times += 1;
        }
        System.out.println(hm);
        int coins = 0;
        System.out.println(A);
        while (A != 0) {
            int i;
            for(i = 0; i < times; i++) {
                if(A < hm.get(i)) {
                    break;
                }
            }
            A -= hm.get(i-1);
            System.out.println(A);
            coins += 1;
        }
        
        System.out.println("coins = " + coins);
        return coins;
    }
    public static void main(String[] args) {
        anotherCoinProblem acp = new anotherCoinProblem();
        // int A = 47;
        int A = 9;

        acp.solve(A);
    }
}
