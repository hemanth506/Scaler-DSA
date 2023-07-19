import java.util.Arrays;
import java.util.HashSet;

public class latestTimeToCatchABus_Q2332 {
    // working code with arrays, sorting and hashing
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int N = buses.length;
        int M = passengers.length;
        if (N == 1 && M == 1) {
            if ((buses[0] < passengers[0]) || (buses[0] > passengers[0] && capacity != 1)) {
                return buses[0];
            }
            return passengers[0] - 1;
        }

        Arrays.sort(buses);
        Arrays.sort(passengers);
        System.out.println(Arrays.toString(buses));
        System.out.println(Arrays.toString(passengers));

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < M; i++) {
            hs.add(passengers[i]);
        }

        int yourArrivalTime = 1;
        int passTime = 0;
        int passCt = 0;
        int busCt = 0;
        for (; busCt < N; busCt++) {
            int curBusTime = buses[busCt];
            passCt = 0;
            while (passTime < M && curBusTime >= passengers[passTime] && passCt < capacity) {
                System.out.println("passTime = " + passengers[passTime]);
                if (!hs.contains(passengers[passTime] - 1)) {
                    yourArrivalTime = passengers[passTime] - 1;
                }
                passTime++;
                passCt++;
            }
            System.out.println("=========");
        }

        if (passCt < capacity) {
            int tempArrTime = buses[busCt - 1];
            while (hs.contains(tempArrTime)) {
                tempArrTime--;
            }
            yourArrivalTime = tempArrTime;
        }
        System.out.println(yourArrivalTime);
        return yourArrivalTime;
    }

    public static void main(String[] args) {
        latestTimeToCatchABus_Q2332 lt = new latestTimeToCatchABus_Q2332();
        // int[] buses = { 20, 30, 10 };
        // int[] passengers = { 19, 13, 26, 4, 25, 11, 21 };
        // int capacity = 2;

        // int[] buses = { 20, 10 };
        // int[] passengers = { 2, 4, 9, 8, 17, 18, 19 };
        // int capacity = 2;

        // int[] buses = { 3 };
        // int[] passengers = { 2, 3 };
        // int capacity = 2;

        int[] buses = { 3 };
        int[] passengers = { 2 };
        int capacity = 2;
        lt.latestTimeCatchTheBus(buses, passengers, capacity);
    }
}
