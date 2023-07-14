import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class brickWall_Q554 {
    public int leastBricks(List<List<Integer>> wall) {
        int N = wall.size();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int brickNotCrossed = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            List<Integer> curArr = wall.get(i);
            int M = curArr.size();
            int sumWidth = 0;
            for(int j = 0; j < M-1; j++) {
                sumWidth += curArr.get(j);
                hm.put(sumWidth, hm.getOrDefault(sumWidth, 0) + 1);
                brickNotCrossed = Integer.max(brickNotCrossed, hm.get(sumWidth));
            }
        }
        int crossed = brickNotCrossed == Integer.MIN_VALUE ? N : N - brickNotCrossed;
        // System.out.println(crossed);
        return crossed;
    }
    public static void main(String[] args) {
        brickWall_Q554 bw = new brickWall_Q554();
        List<List<Integer>> wall = new ArrayList<>();
        // wall.add(new ArrayList<Integer>(Arrays.asList(1,2,2,1)));
        // wall.add(new ArrayList<Integer>(Arrays.asList(3,1,2)));
        // wall.add(new ArrayList<Integer>(Arrays.asList(1,3,2)));
        // wall.add(new ArrayList<Integer>(Arrays.asList(2,4)));
        // wall.add(new ArrayList<Integer>(Arrays.asList(3,1,2)));
        // wall.add(new ArrayList<Integer>(Arrays.asList(1,3,1,1)));

        wall.add(new ArrayList<Integer>(Arrays.asList(1)));
        wall.add(new ArrayList<Integer>(Arrays.asList(1)));
        wall.add(new ArrayList<Integer>(Arrays.asList(1)));

        bw.leastBricks(wall);
    }
}
