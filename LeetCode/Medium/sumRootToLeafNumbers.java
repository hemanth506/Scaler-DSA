import Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import Medium.Pair_Tree_StrBld;

public class sumRootToLeafNumbers {
    
    // try using level order ==> Memory limit exceed
    public int sumNumbers_OLD(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Pair_Tree_StrBld pr = new Pair_Tree_StrBld(root, sb);
        Queue<Pair_Tree_StrBld> que = new LinkedList<>();
        que.add(pr);
        
        while (!que.isEmpty()) {
            int N = que.size();
            for(int i = 0; i < N; i++) {
                Pair_Tree_StrBld curPr = que.peek();
                TreeNode cNode = curPr.tr;
                StringBuilder cStrBr = curPr.sb;

                if(cNode.left == null && cNode.right == null) {
                    String str = sb.toString();
                    int ans = Integer.parseInt(str);
                    result += ans;
                }


                if(cNode.left != null) {
                    // newSb.append(cNode.left.val);
                    cStrBr.append(cNode.left.val);
                    StringBuilder newSb = new StringBuilder(cStrBr);
                    Pair_Tree_StrBld newPr = new Pair_Tree_StrBld(cNode.left, newSb);
                    que.add(newPr);
                }

                if(cNode.right != null) {
                    // newSb.append(cNode.left.val);
                    cStrBr.append(cNode.right.val);
                    StringBuilder newSb = new StringBuilder(cStrBr);
                    Pair_Tree_StrBld newPr = new Pair_Tree_StrBld(cNode.right, newSb);
                    que.add(newPr);
                }
            }
        }

        return result;
    }


    public void getSumOld(TreeNode root, StringBuilder sb) {
        if(root == null) {
            String str = sb.toString();
            System.out.println("str in base = " + str);
            if(str.length() > 0) {
                int ans = Integer.parseInt(str);
                result += ans;
            }
            return;
        }

        System.out.println("str added = " + root.val);
        StringBuilder sbTemp = new StringBuilder(sb);
        sb.append(root.val);
        getSumOld(root.left, sb);
        String str = sb.toString();
        System.out.println("str after left = " + str);

        int len = sb.toString().length() - 1;
        // System.out.println(len);
        sb.deleteCharAt(len);

        String str1 = sbTemp.toString();
        System.out.println("str after delete and before go right = " + str1);
        getSumOld(root.right, sb);

    }

    
    public void getSumOLD2(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;   
        }

        if(root.left == null && root.right == null && sb.length() > 0) {
            String str = sb.toString();
            // System.out.println("str in base = " + str);
            int ans = Integer.parseInt(str);
            result += ans;
            return;
        }

        sb.append(root.val);
        getSum(root.left, sb);

        // String str = sb.toString();
        // System.out.println("str after left = " + str);

        int len = sb.toString().length() - 1;
        sb.deleteCharAt(len);

        // String str1 = sb.toString();
        // System.out.println("str after delete and before go right = " + str1);
        // sb.append(root.right.val);
        getSum(root.right, sb);

    }


    // working code
    int result = 0;
    public void getSum(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(root.val);
            String str = newSb.toString();
            int ans = Integer.parseInt(str);
            result += ans;
            return;
        }

        if(root.left != null && root.right != null) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(root.val);
            getSum(root.left, newSb);
            getSum(root.right, newSb);
        }

        if(root.left == null && root.right != null) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(root.val);
            getSum(root.right, newSb);
        }


        if(root.left != null && root.right == null) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(root.val);
            getSum(root.left, newSb);
        }
    }

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getSum(root, sb);
        return result;
    }
}
