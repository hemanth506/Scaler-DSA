import java.util.ArrayList;
import java.util.Deque;
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

public class reverseLevelOrder {
    // Iterative way
    public ArrayList<Integer> solveIterativeWay(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> que = new LinkedList<>();
        Stack<ArrayList<Integer>> nestArr = new Stack<>();
        ArrayList<Integer> finalarr = new ArrayList<>();

        que.add(tempA);
        finalarr.add(que.peekLast().val);
        while (!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            boolean leftExist = false;
            boolean rightExist = false;

            while(ct <= N) {
                TreeNode peekNode = que.peekFirst();
                if(peekNode.left != null) {
                    que.add(peekNode.left);
                    arr.add(peekNode.left.val);
                    leftExist = true;
                }

                if(peekNode.right != null) {
                    que.add(peekNode.right);
                    arr.add(peekNode.right.val);
                    rightExist = true;
                }
                ct += 1;
            }
            if(leftExist || rightExist) {
                nestArr.add(arr);
            }
        }

        ArrayList<Integer> finArr = new ArrayList<>();
        while(!nestArr.isEmpty()) {
            int nn = nestArr.peek().size();
            ArrayList<Integer> newArr = nestArr.peek();
            for(int j = 0; j < nn; j++) {
                finArr.add(newArr.get(j));
            }
            nestArr.pop();
        }
        return finArr;    
    }

    // Recursion Way
    public ArrayList<Integer> solveRecursionWay(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>(); 
        que.add(tempA);
        reverse(que, arr);
        arr.add(tempA.val);
        return arr;
    }

    public void reverse (Queue<TreeNode> que, ArrayList<Integer> arr) {
        if(que.isEmpty()) {
            return;
        }
        TreeNode curNode = que.peek();
        if(curNode.left != null) {
            que.add(curNode.left);
        }
        if(curNode.right != null) {
            que.add(curNode.right);
        }
        que.poll();
        reverse(que, arr);
        if(curNode.left != null) {
            arr.add(curNode.left.val);
        }
        if(curNode.right != null) {
            arr.add(curNode.right.val);
        }
    }
    
}
