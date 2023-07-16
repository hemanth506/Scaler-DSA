import Medium.TreeNode;
import Medium.Pair_Tree_Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class printBinaryTree_Q655 {

    public List<List<String>> printTree(TreeNode root) {
        TreeNode head = root;
        int height = getHeight(head) - 1;
        System.out.println(height);
        int N = height + 1;
        int pow = calculatePower(2, height + 1);
        int M = pow - 1;

        List<List<String>> finalArr = createListSting(N, M);
        Queue<Pair_Tree_Array> que = new LinkedList<>();

        int i = 0; int j = (M-1)/2;
        finalArr.get(i).set(j, root.val+"");
        que.add(new Pair_Tree_Array(root, i, j));

        System.out.println(finalArr);

        while(!que.isEmpty()) {
            int P = que.size();
            for(int x = 0; x < P; x++) {
                Pair_Tree_Array pr = que.poll();
                TreeNode node = pr.node;
                System.out.println(node);
                int row = pr.index[0];
                int col = pr.index[1];

                if(node.left != null) {
                    int i1 = row + 1;
                    int j1 = col - calculatePower(2, height - row - 1);
                    Pair_Tree_Array newPr = new Pair_Tree_Array(node.left, i1, j1);
                    que.add(newPr);
                    finalArr.get(i1).set(j1, node.left.val + "");
                }

                if(node.right != null) {
                    int i1 = row + 1;
                    int j1 = col + calculatePower(2, height - row - 1);
                    Pair_Tree_Array newPr = new Pair_Tree_Array(node.right, i1, j1);
                    que.add(newPr);
                    finalArr.get(i1).set(j1, node.right.val + "");
                }
            }
        }
        System.out.println(finalArr);
        return finalArr;
    }

    private List<List<String>> createListSting(int N, int M) {
        List<List<String>> finalArr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            List<String> arrStr = new ArrayList<>();
            for(int j = 0; j < M; j++) {
                arrStr.add("");
            }
            finalArr.add(arrStr);
        }
        System.out.println(finalArr);
        return finalArr;
    }

    private int calculatePower(int i, int j) {
        if (j == 0) {
            return 1;
        }
        return calculatePower(i, j - 1) * i;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Integer.max(left, right) + 1;
    }

}
