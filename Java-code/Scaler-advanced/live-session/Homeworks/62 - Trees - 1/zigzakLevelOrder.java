import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

public class zigzakLevelOrder {
    // append the array and reverse array
    public ArrayList<ArrayList<Integer>> zigzagLevelOrderReverse(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> nestArr = new ArrayList<>();
        que.add(tempA);
        nestArr.add(que.peek().val);
        arr.add(nestArr);
        while (!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            nestArr = new ArrayList<>();
            boolean leftCheck = false;
            boolean rightCheck = false;

            while (ct <= N) {
                if (que.peek().left != null) {
                    que.add(que.peek().left);
                    nestArr.add(que.peek().left.val);
                    leftCheck = true;
                }

                if (que.peek().right != null) {
                    que.add(que.peek().right);
                    nestArr.add(que.peek().right.val);
                    rightCheck = true;
                }
                ct += 1;
                que.poll();
            }
            if (leftCheck || rightCheck) {
                arr.add(nestArr);
            }
        }
        int N = arr.size();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                Collections.reverse(arr.get(i));
            }
        }
        return arr;
    }

    // reverse array when appending using 2 stack
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        TreeNode tempA = A;
        Stack<TreeNode> stkEven = new Stack<>();
        Stack<TreeNode> stkOdd = new Stack<>();
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        // Level 1
        stkOdd.add(tempA);

        int level = 1;
        while(!stkEven.isEmpty() || !stkOdd.isEmpty()) {
            arr = new ArrayList<>();
            boolean hasLeft = false;
            boolean hasRight = false;

            if(level % 2 == 0) {
                while(!stkOdd.isEmpty()) {
                    TreeNode curNode = stkOdd.peek();
                    if(curNode.left != null) {
                        stkEven.add(curNode.left);
                        hasLeft = true;
                    }
                    if(curNode.right != null) {
                        stkEven.add(curNode.right);
                        hasRight = true;
                    }
                    arr.add(curNode.val);
                    stkOdd.pop();
                }
            } else {
                while(!stkEven.isEmpty()) {
                    TreeNode curNode = stkEven.peek();
                    if(curNode.right != null) {
                        stkOdd.add(curNode.right);
                        hasRight = true;
                    }
                    if(curNode.left != null) {
                        stkOdd.add(curNode.left);
                        hasLeft = true;
                    }
                    arr.add(curNode.val);
                    stkEven.pop();
                }
            }
            if(hasLeft || hasRight) {
                finalArr.add(arr);
            }
            level+=1;
        }
        // Add the final arr in the finalArr, since we are using stack.
        finalArr.add(arr);
        return finalArr;
    }
}
