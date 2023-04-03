import java.util.Arrays;

/*
 * Since the question is asked to take atmost 2 person in the boat, 
 * we can get the heaviest and the lightest person in the one boat,
 * for this "TWO POINTER TECHNIQUE" is used.
 * 
 * If the question did not mention people limit we can use "BINAR SEARCH" itself.
 */

public class boatsToSavePeople {
    
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int N = people.length;

        int boats = 0;
        int l = 0;
        int h = N - 1;
        while(l <= h) {
            if(people[l] + people[h] <= limit) {
                boats+=1;
                l++; h--;
            } else {
                boats+= 1;
                h--;
            }
        }

        System.out.println(boats);
        return boats;
    }

    public static void main(String[] args) {
        boatsToSavePeople bts = new boatsToSavePeople();
        int[] people = { 3, 2, 2, 1 };
        int limit = 3;

        // int[] people = { 3,5,3,4 };
        // int limit = 5;

        // int[] people = { 1,2 };
        // int limit = 3;

        // int[] people = { 2, 2 };
        // int limit = 6;

        // int[] people = { 3,8,7,1,4 };
        // int limit = 9;
        bts.numRescueBoats(people, limit);
    }
}
