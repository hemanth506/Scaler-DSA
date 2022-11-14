import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode A, int B) {
        node = A;
        level = B;
    }
}

public class verticalLevelOrder {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeNode tempA = A;
        Queue<Pair> que = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int minV = 0;
        int maxV = 0;
        Pair pr = new Pair(tempA, 0);
        que.add(pr);
        while(!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            while (ct <= N) {
                Pair tempPr = que.peek();
                TreeNode node = tempPr.node;
                int level = tempPr.level;
                minV = Integer.min(minV, level);
                maxV = Integer.max(maxV, level);

                if(hm.containsKey(level)) {
                    ArrayList<Integer> ar = hm.get(level);
                    ar.add(node.val);
                    hm.put(level, ar);
                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(node.val);
                    hm.put(level, ar);
                }

                if(node.left != null) {
                    pr = new Pair(node.left, level-1);
                    que.add(pr);
                }

                if(node.right != null) {
                    pr = new Pair(node.right, level+1);
                    que.add(pr);
                }
                ct+=1;
                que.poll();
            }
        }
        // System.out.println(hm);
        // System.out.println(minV + " " + maxV);

        ArrayList<ArrayList<Integer>> finArr = new ArrayList<>();
        for(int i = minV; i <= maxV; i++) {
            // System.out.println(i);
            int size = hm.get(i).size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int k = 0; k < size; k++) {
                al.add(hm.get(i).get(k));
            }
            finArr.add(al);
        }
        return finArr;
    }
}
