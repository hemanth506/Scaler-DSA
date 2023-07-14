import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class keysAndRooms_Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new LinkedList<>();

        
        int zerothRoomSize = rooms.get(0).size();
        visited[0] = true;
        for(int i = 0; i < zerothRoomSize; i++) {
            que.add(rooms.get(0).get(i));
        }

        while(!que.isEmpty()) {
            int keysAvailInQueue = que.size();
            for(int i = 0; i < keysAvailInQueue; i++) {
                int curRoomId = que.poll();
                if(!visited[curRoomId]) {
                    visited[curRoomId] = true;
                    List<Integer> curRoom = rooms.get(curRoomId);
                    for(int k = 0; k < curRoom.size(); k++) {
                        que.add(curRoom.get(k));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        keysAndRooms_Q841 kr = new keysAndRooms_Q841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(3, 0, 1)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(2)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(0)));

        // rooms.add(new ArrayList<Integer>(Arrays.asList(1)));
        // rooms.add(new ArrayList<Integer>(Arrays.asList(2)));
        // rooms.add(new ArrayList<Integer>(Arrays.asList(3)));
        // rooms.add(new ArrayList<Integer>(Arrays.asList()));

        kr.canVisitAllRooms(rooms);
    }
}
