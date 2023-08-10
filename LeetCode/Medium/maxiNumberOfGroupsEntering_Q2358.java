import java.util.Arrays;

public class maxiNumberOfGroupsEntering_Q2358 {
    public int maximumGroups(int[] grades) {
        int N = grades.length;
        Arrays.sort(grades);

        int groups = 0;
        int i = 0;
        int ct = 0;
        while (ct < N) {
            groups += 1;
            i = i + 1;
            ct += i;
        }
        if(ct > N) {
            groups--;
        }
        return groups;
    }
    public static void main(String[] args) {
        maxiNumberOfGroupsEntering_Q2358 mn = new maxiNumberOfGroupsEntering_Q2358();
        // int[] grades = {10,6,4,3,3,1,1,1,1,1};
        // int[] grades = {10,6,12,7,3,5};
        // int[] grades = {8,8};
        // int[] grades = {10,6,12,7,3,5,4,8,9,13,14};
        int[] grades = {47,2,16,17,41,4,38,23,47};
        mn.maximumGroups(grades);
    }
}
